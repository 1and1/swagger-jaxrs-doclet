package com.hypnoticocelot.jaxrs.doclet.parser;

import static com.google.common.base.Objects.firstNonNull;
import static com.google.common.collect.Maps.uniqueIndex;
import static com.hypnoticocelot.jaxrs.doclet.parser.AnnotationHelper.parsePath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.hypnoticocelot.jaxrs.doclet.DocletOptions;
import com.hypnoticocelot.jaxrs.doclet.model.Api;
import com.hypnoticocelot.jaxrs.doclet.model.ApiDeclaration;
import com.hypnoticocelot.jaxrs.doclet.model.Method;
import com.hypnoticocelot.jaxrs.doclet.model.Model;
import com.hypnoticocelot.jaxrs.doclet.model.Operation;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.Tag;
import com.sun.javadoc.Type;

/**
 * The CrossClassApiParser represents an api class parser that supports ApiDeclaration being
 * spread across multiple resource classes.
 * @version $Id$
 * @author conor.roche
 */
public class CrossClassApiParser {

	private final DocletOptions options;
	private final ClassDoc classDoc;
	private final String rootPath;
	private final String swaggerVersion;
	private final String apiVersion;
	private final String basePath;

	/**
	 * This creates a CrossClassApiParser
	 * @param options
	 * @param classDoc
	 * @param swaggerVersion Swagger version
	 * @param apiVersion Overall API version
	 * @param basePath Overall base path
	 */
	public CrossClassApiParser(DocletOptions options, ClassDoc classDoc, String swaggerVersion, String apiVersion, String basePath) {
		super();
		this.options = options;
		this.classDoc = classDoc;
		this.rootPath = firstNonNull(parsePath(classDoc.annotations()), "");
		this.swaggerVersion = swaggerVersion;
		this.apiVersion = apiVersion;
		this.basePath = basePath;
	}

	/**
	 * This gets the root jaxrs path of the api resource class
	 * @return The root path
	 */
	public String getRootPath() {
		return this.rootPath;
	}

	/**
	 * This parses the api declarations from the resource classes of the api
	 * @param declarations The map of resource name to declaration which will be added to
	 */
	public void parse(Map<String, ApiDeclaration> declarations) {

		// read the class see tags
		Map<String, Type> seeTypes = AnnotationHelper.readSeeTypes(this.classDoc);

		// read default error type for class
		String defaultErrorTypeClass = AnnotationHelper.getTagValue(this.classDoc, this.options.getDefaultErrorTypeTags());
		Type defaultErrorType = seeTypes.get(defaultErrorTypeClass);

		Set<Model> classModels = new HashSet<Model>();
		if (this.options.isParseModels() && defaultErrorType != null) {
			classModels.addAll(new ApiModelParser(this.options, this.options.getTranslator(), defaultErrorType).parse());
		}

		for (MethodDoc method : this.classDoc.methods()) {
			ApiMethodParser methodParser = new ApiMethodParser(this.options, this.rootPath, method, seeTypes, defaultErrorTypeClass);
			Method parsedMethod = methodParser.parse();
			if (parsedMethod == null) {
				continue;
			}
			// see which resource path to use for the method, if its got a resourceTag then use that
			// otherwise use the root path
			String resourcePath = getRootPath();
			if (this.options.getResourceTags() != null) {
				for (String resourceTag : this.options.getResourceTags()) {
					Tag[] tags = method.tags(resourceTag);
					if (tags != null && tags.length > 0) {
						resourcePath = tags[0].text();
						resourcePath = resourcePath.toLowerCase();
						resourcePath = resourcePath.trim().replace(" ", "_");
						if (!resourcePath.startsWith("/")) {
							resourcePath = "/" + resourcePath;
						}
						break;
					}
				}
			}

			Set<Model> methodModels = methodParser.models();
			methodModels.addAll(classModels);
			Map<String, Model> idToModels = Collections.emptyMap();
			try {
				idToModels = uniqueIndex(methodModels, new Function<Model, String>() {

					public String apply(Model model) {
						return model.getId();
					}
				});
			} catch (Exception ex) {
				throw new IllegalStateException("dupe models, method : " + method + ", models: " + methodModels, ex);
			}

			ApiDeclaration declaration = declarations.get(resourcePath);
			if (declaration == null) {
				declaration = new ApiDeclaration(this.swaggerVersion, this.apiVersion, this.basePath, resourcePath, null, null, Integer.MAX_VALUE, null);
				declaration.setApis(new ArrayList<Api>());
				declaration.setModels(new HashMap<String, Model>());
				declarations.put(resourcePath, declaration);
			}

			// look for a method level priority tag for the resource listing and set on the resource if the resource hasnt had one set
			int priorityVal = Integer.MAX_VALUE;
			String priority = AnnotationHelper.getTagValue(method, this.options.getResourcePriorityTags());
			if (priority != null) {
				try {
					priorityVal = Integer.parseInt(priority);
				} catch (NumberFormatException ex) {
					System.err.println("Warning invalid priority tag value: " + priority + " on method doc: " + method);
				}
			}
			if (priorityVal != Integer.MAX_VALUE && declaration.getPriority() == Integer.MAX_VALUE) {
				declaration.setPriority(priorityVal);
			}
			// look for a method level description tag for the resource listing and set on the resource if the resource hasnt had one set
			String description = AnnotationHelper.getTagValue(method, this.options.getResourceDescriptionTags());
			if (description != null && declaration.getDescription() == null) {
				declaration.setDescription(description);
			}

			// find api this method should be added to
			String realMethodPath = parsedMethod.getPath();
			Api methodApi = null;
			for (Api api : declaration.getApis()) {
				if (realMethodPath.equals(api.getPath())) {
					methodApi = api;
					break;
				}
			}
			if (methodApi == null) {
				methodApi = new Api(realMethodPath, "", new ArrayList<Operation>());
				declaration.getApis().add(methodApi);
			}

			methodApi.getOperations().add(new Operation(parsedMethod));

			declaration.getModels().putAll(idToModels);

		}

	}

}
