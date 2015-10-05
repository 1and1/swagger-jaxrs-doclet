package com.carma.swagger.doclet.parser;

import java.util.Collection;
import java.util.Collections;

import com.carma.swagger.doclet.DocletOptions;
import com.sun.javadoc.Type;

/**
 * The FieldReader represents a util class for reading details about fields/return types
 * @version $Id$
 * @author conor.roche
 */
public class FieldReader {

	private final DocletOptions options;

	/**
	 * This creates a FieldReader
	 * @param options
	 */
	public FieldReader(DocletOptions options) {
		this.options = options;
	}

	/**
	 * This gets the description of a field/method
	 * @param docItem the method/field
	 * @param useCommentText whether to use comment text of the method/field
	 * @return the description taken first from field description tags otherwise the comment text (assuming useCommentText is true)
	 */
	public String getFieldDescription(com.sun.javadoc.MemberDoc docItem, boolean useCommentText) {
		// method
		String description = ParserHelper.getTagValue(docItem, this.options.getFieldDescriptionTags(), this.options);
		if (description == null && useCommentText) {
			description = docItem.commentText();
		}
		if (description == null || description.trim().length() == 0) {
			return null;
		}

		return this.options.replaceVars(description.trim());
	}

	/**
	 * This gets the min value for the field/method or null if there is none
	 * @param docItem the method/field
	 * @param fieldType the field/method return type
	 * @return the min value for the field/method or null if there is none
	 */
	public String getFieldMin(com.sun.javadoc.MemberDoc docItem, Type fieldType) {
		// ignore annotations on fields that are not numeric
		Collection<String> annotations = this.options.getFieldMinAnnotations();
		if (!ParserHelper.isNumber(fieldType, this.options)) {
			annotations = Collections.emptyList();
		}

		String val = ParserHelper.getAnnotationOrTagValue(docItem, annotations, this.options.getFieldMinTags(), this.options, new String[] { "value", "min" });
		if (val != null && val.trim().length() > 0) {
			return this.options.replaceVars(val.trim());
		}
		return null;
	}

	/**
	 * This gets the max value for the field/method or null if there is none
	 * @param docItem the method/field
	 * @param fieldType the field/method return type
	 * @return the max value for the field/method or null if there is none
	 */
	public String getFieldMax(com.sun.javadoc.MemberDoc docItem, Type fieldType) {
		// ignore annotations on fields that are not numeric
		Collection<String> annotations = this.options.getFieldMaxAnnotations();
		if (!ParserHelper.isNumber(fieldType, this.options)) {
			annotations = Collections.emptyList();
		}

		String val = ParserHelper.getAnnotationOrTagValue(docItem, annotations, this.options.getFieldMaxTags(), this.options, new String[] { "value", "max" });
		if (val != null && val.trim().length() > 0) {
			return this.options.replaceVars(val.trim());
		}
		return null;
	}

	/**
	 * This gets the default value for the field/method
	 * @param docItem the method/field
	 * @param fieldType the field/method return type
	 * @return the default value for the field/method or null if there is none
	 */
	public String getFieldDefaultValue(com.sun.javadoc.MemberDoc docItem, Type fieldType) {
		String val = ParserHelper.getTagValue(docItem, this.options.getFieldDefaultTags(), this.options);
		// if its a boolean then convert to lowercase true/false
		if (val != null && val.trim().length() > 0) {
			val = this.options.replaceVars(val.trim());
		}
		if (val != null && fieldType.simpleTypeName().equalsIgnoreCase("boolean")) {
			val = val.toLowerCase();
		}
		return val == null ? null : val;
	}

	/**
	 * This gets the format for the field/method as specifed by the field format tags, if there is no such tag
	 * on the field/method it returns null
	 * @param docItem the method/field
	 * @param fieldType the field/method return type
	 * @return the format for the field/method as specifed by the field format tags, if there is no such tag
	 *         on the field/method it returns null
	 */
	public String getFieldFormatValue(com.sun.javadoc.MemberDoc docItem, Type fieldType) {
		String val = ParserHelper.getTagValue(docItem, this.options.getFieldFormatTags(), this.options);
		if (val != null && val.trim().length() > 0) {
			val = this.options.replaceVars(val.trim());
		}
		return val == null ? null : val;
	}

	/**
	 * This gets whether the field is required
	 * @param docItem the field/method
	 * @return True/False if the item is known to be/not be required, null if not known
	 */
	public Boolean getFieldRequired(com.sun.javadoc.MemberDoc docItem) {

		if (ParserHelper.hasAnnotation(docItem, this.options.getRequiredFieldAnnotations(), this.options)
				|| ParserHelper.hasTag(docItem, this.options.getRequiredFieldTags())) {
			return Boolean.TRUE;
		}
		if (ParserHelper.hasAnnotation(docItem, this.options.getOptionalFieldAnnotations(), this.options)
				|| ParserHelper.hasTag(docItem, this.options.getOptionalFieldTags())) {
			return Boolean.FALSE;
		}
		Boolean notSpecified = null;
		return notSpecified;
	}

}
