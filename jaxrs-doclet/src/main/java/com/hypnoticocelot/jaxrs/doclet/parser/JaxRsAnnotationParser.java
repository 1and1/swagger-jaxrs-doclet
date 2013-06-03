package com.hypnoticocelot.jaxrs.doclet.parser;

import com.google.common.base.Function;
import com.hypnoticocelot.jaxrs.doclet.DocletOptions;
import com.hypnoticocelot.jaxrs.doclet.ServiceDoclet;
import com.hypnoticocelot.jaxrs.doclet.model.*;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.google.common.collect.Maps.uniqueIndex;

public class JaxRsAnnotationParser {

    private final Translator translator;
    private final DocletOptions options;
    private final RootDoc rootDoc;

    public JaxRsAnnotationParser(Translator translator, DocletOptions options, RootDoc rootDoc) {
        this.translator = translator;
        this.options = options;
        this.rootDoc = rootDoc;
    }

    public boolean run() {
        try {
            Collection<ApiDeclaration> declarations = new ArrayList<ApiDeclaration>();
            for (ClassDoc classDoc : rootDoc.classes()) {
                ApiClassParser classParser = new ApiClassParser(translator, options, classDoc);
                Collection<Api> apis = classParser.parse();
                if (apis.isEmpty()) {
                    continue;
                }

                // The idea behind this declaration is that "/foo" and "/foo/annotated" are stored in separate "Api" classes but are essentially the same APIs.
                // ... "Api" class should actually include all API methods, but with paths.
                Map<String, Model> models = uniqueIndex(classParser.models(), new Function<Model, String>() {
                    @Override
                    public String apply(Model model) {
                        return model.getId();
                    }
                });
                declarations.add(new ApiDeclaration(options.getApiVersion(), options.getApiBasePath(), apis, models));
            }
            writeApis(declarations);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void writeApis(Collection<ApiDeclaration> apis) throws IOException {
        List<ResourceListingAPI> resources = new LinkedList<ResourceListingAPI>();
        for (ApiDeclaration api : apis) {
            String apiPath = api.getApis().iterator().next().getPath();
            String rootPath = (apiPath.startsWith("/") ? apiPath.replaceFirst("/", "") : apiPath).replaceAll("/", "_").replaceAll("(\\{|\\})", "");
            resources.add(new ResourceListingAPI("/" + rootPath + ".{format}", ""));

            File apiFile = new File(options.getOutput(), rootPath + ".json");
            options.getRecorder().record(apiFile, api);
        }

        //write out json for api
        ResourceListing listing = new ResourceListing(options.getApiVersion(), options.getDocBasePath(), resources);
        File docFile = new File(options.getOutput(), "service.json");
        options.getRecorder().record(docFile, listing);

        // Copy swagger-ui into the output directory.
        final ZipInputStream swaggerZip = new ZipInputStream(ServiceDoclet.class.getResourceAsStream("/swagger-ui.zip"));
        ZipEntry entry = swaggerZip.getNextEntry();
        while (entry != null) {
            final File swaggerFile = new File(options.getOutput(), entry.getName());
            if (entry.isDirectory()) {
                if (!swaggerFile.isDirectory() && !swaggerFile.mkdirs()) {
                    throw new RuntimeException("Unable to create directory: " + swaggerFile);
                }
            } else {
                options.getRecorder().record(swaggerFile, swaggerZip);
            }

            entry = swaggerZip.getNextEntry();
        }
        swaggerZip.close();
    }

}
