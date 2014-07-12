# Swagger Doclet 

A JavaDoc Doclet that can be used to generate a Swagger resource listing suitable for feeding to
swagger-ui. Forked from https://github.com/ryankennedy/swagger-jaxrs-doclet to add support for swagger 1.2 and includes various fixes described below. This is used as a basis for the Carma API https://api-dev.car.ma/apidoc/ref/index.html Note you can win $1,000,000 using this API see http://carmacarpool.com/prize

## Usage

To use the Swagger Doclet in your Maven project, add the following to your POM file.

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>…</groupId>
    <artifactId>…</artifactId>
    <version>…</version>
    
    <dependencies>
        …
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-javadoc-plugin</artifactId>
                <version>2.9.1</version>
                <executions>
                    <execution>
                        <id>generate-service-docs</id>
                        <phase>generate-resources</phase>
                        <configuration>
                            <doclet>com.hypnoticocelot.jaxrs.doclet.ServiceDoclet</doclet>
                            <docletArtifact>
                                <groupId>com.hypnoticocelot</groupId>
                                <artifactId>jaxrs-doclet</artifactId>
                                <version>0.0.4_carma-SNAPSHOT</version>
                            </docletArtifact>
                            <reportOutputDirectory>${project.build.outputDirectory}</reportOutputDirectory>
                            <useStandardDocletOptions>false</useStandardDocletOptions>
                            <additionalparam>-apiVersion 1 -docBasePath /apidocs -apiBasePath /</additionalparam>
                        </configuration>
                        <goals>
                            <goal>javadoc</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</xml>

```

## Supported Javadoc Tags and Annotations

<table>
	<tr><th>Tag</th><th>Purpose</th><th>Applies To</th><th>Aliases</th></tr>
	<tr><td>@exclude</td><td>Use to exclude a resource operation, model field or method from the generated documentation</td><td>operations, model methods & fields</td><td>@hidden, @hide</td></tr>
	<tr><td>@excludeParams</td><td>Use to exclude operation parameters from the generated documentation</td><td>operations</td><td>@hiddenParams, @hideParams</td></tr>
	<tr><td>@responseMessage</td><td>Use to describe each success or response status returned from an operation. It is made up of a numeric status code, a description an an optional response model specifically for this error.<br><br>For example:<br><br>
	@responseMessage 404 not found<br><br>
	@responseMessage 404 not found `fixtures.responsemessages.Response1<br><br>
	NOTE: The optional response model class is added after a backtick as in the example above. 
	</td><td>operations</td><td>@status, @errorResponse, @successResponse, @errorCode, @successCode</td></tr>
	<tr><td>@responseType</td><td>If you want the documented response model class to be different to the one in the java method signature you can use this to override it. This is useful to replace the Jax Rs response class with a particular entity type that may be returned. For example: 
	<p>
	<code><pre>
	/**
	 * @responseType fixtures.responsemodel.Response2
	 */
	@SuppressWarnings("javadoc")
	@GET
	public Response responseDefinedViaTag() {
		return Response.ok().entity(new Response2()).build();
	}
	</pre></code></p>In the above method the response model documented will be fixtures.responsemodel.Response2
	<br><br>
	</td><td>operations</td><td>@outputType</td></tr>
	<tr><td>@inputType</td><td>If you want to have a different class type used as the model for a body parameter then you can use this. For example: 
	<p>
	<code><pre>
	/**
	 * @inputType fixtures.inputtype.Data2
	 */
	@POST
	@Path("/postData2b")
	public Response postData2b(@HeaderParam("X-forwarded-for") String xFwd, @QueryParam("p1") int p1, Data1 data) {
		return Response.ok().build();
	}
	</pre></code></p>In the above method the body parameter model documented will be fixtures.inputtype.Data2
	</td><td>PUT/POST operations</td><td>@bodyType</td></tr>
	<tr><td>@defaultErrorType</td><td>If error responses result in an error entity and you want to document this without having to put in each error responseMessage you can set this either on the operation method or the resource classes javadoc.</td><td>operations,resource classes</td><td></td></tr>
	<tr><td>@description</td><td>For model properties this is used for the field description. For operations this is used for the notes. For operations if you do not use this then the notes will be taken from the commment text minus the first sentences of the javadoc.</td><td>operations, model methods</td><td>@comment, @return - (only for model methods)</td></tr>
	<tr><td>@summary</td><td>This is used for the summary of the operation. If you do not use this then the summary will be taken from the first sentences of the javadoc.</td><td>operations</td><td>@endpointName</td></tr>
	<tr><td>@min</td><td>Defines a minimum value for a model field.</td><td>model fields and methods</td><td>@minimum</td></tr>
	<tr><td>@max</td><td>Defines a maximum value for a model field.</td><td>model fields and methods</td><td>@maximum</td></tr>
	
	<tr><td>@requiredParams</td><td>Defines a csv of operation parameter names that are required. If a param is not in the requiredParams list then it is required if it is a path or body param unless it is in the @optionalParams list.</td><td>operations</td><td></td></tr>
	
	<tr><td>@optionalParams</td><td>Defines a csv of operation parameter names that are optional. If a param is not in the optionalParams list then it is optional if it is NOT a path or body param unless it is in the @requiredParams list.</td><td>operations</td><td></td></tr>
	
	<tr><td>@csvParams</td><td>Defines a csv of operation parameter names that use CSV values. For swagger 1.2 this results in the allowMultiple field being set to true, however the swagger ui does not support this at present.</td><td>operations</td><td></td></tr>
	
	<tr><td>@resourcePriority</td><td>This sets a priority for ordering resources in the resource listing. They are ordered in ascending order of priority provided the doclet option -sortResourcesByPriority is set</td><td>operations</td><td>@resourceOrder</td></tr>
	<tr><td>@resourceDescription</td><td>This sets the description for an operation in the resource listing e.g. the service.json file. If you are using the standard api class parser then you should put this tag on the class javadoc. If you are using the cross class resource parser then you should put this tag on one of the operation methods of each resource.</td><td>operations (if using cross class parsing), class javadoc</td><td></td></tr>
	<tr><td>@unauthorized</td><td>Indicates a method does NOT require authentication, in this case an empty authorizations field will be added to the operation json e.g. authorizations": { } The swagger 1.2 spec indicates this overrides authentication at the api level however in practice it appears that not adding this vs adding empty authorizations has the same effect in Swagger UI.</td><td>operations</td><td>@noAuth</td></tr>
	<tr><td>@scope</td><td>Indicates this method requires authorization and in particular the calling user must have this scope. Multiple scopes can be added using multiple tags. The scopes defined on the operation level must be one of the scopes in the Authorizations section of the service.json</td><td>operations</td><td>@oauth2Scope</td></tr>
	<tr><td>@authentication</td><td>This is an alternative way to define that an endpoint either requires authorization or does not require authorization. It can be set to either @authentication Required or @authentication Not required. If it is set to required then you must also set some default scopes that are to be applied via the -authOperationScopes doclet option.</td><td>operations</td><td>@authorization</td></tr>
	<tr><td>@deprecated</td><td>This defines an operation method or a model field/method as deprecated. By default the doclet will not include these in the generated documentation. This behaviour can be overridden by the -disableDeprecated* options described in the doclet options section below.</td><td>operations, model fields & methods.</td><td></td></tr>
	<tr><td>@Deprecated</td><td>This defines an operation method, parameter or a model field/method as deprecated. By default the doclet will not include these in the generated documentation. This behaviour can be overridden by the -disableDeprecated* options described in the doclet options section below. As this is an annotation vs a javadoc tag it can be applied to operation parameters.</td><td>operations, operation parameters, model fields & methods.</td><td></td></tr>
	
</table>

## Doclet Options

### Mandatory Options

These are the options that you will always want to set

<table>
	<tr><th>Option</th><th>Purpose</th></tr>
	<tr><td>-docBasePath</td><td>The base path to the docs in the service.json, defaults to http://localhost:8080. You should set to the url of the dir where the swagger json files are hosted e.g. for Carma we use -docBasePath https://api-dev.car.ma/apidoc/ref. NOTE: Do not end this with a forward slash.</td></tr>
	<tr><td>-apiBasePath</td><td>The base path to make api calls via swagger ui, For each API operation the url to that operation is the apiBasePath + the operation Api path. This can be relative if the swagger json files are on the same host as you API. For Carma we use -apiBasePath /carmaapi</td></tr>
	<tr><td>-apiVersion</td><td>The version of your API used in the service.json and your various API json files.</td></tr>
</table>

### Customizable Options

These are the options that you may want to use to add additional functionality or control the doclet behaviour

<table>
	<tr><th>Option</th><th>Purpose</th></tr>
	<tr><td>-d</td><td>The path to the directory where the generated swagger json files should be written e.g. -d /tmp/foo. By default this will be the reportOutputDirectory of the doclet.</td></tr>
	<tr><td>-apiAuthorizationsFile</td><td>The path to the json include file that contains the authorizations spec that should be included in the generated json. For example for Carma we use: 
	<p></p>
	<p>-apiAuthorizationsFile ${project.build.directory}/swagger/includes/apiauth.json</p>
	
	which includes this content:
	
	<code><pre>
	{
  "oauth2": {
    "type": "oauth2",
    "scopes": [
      {
        "scope": "rtr",
        "description": "Standard Carma Scope allowing access to the authenticated user"
      }
    ],
    "grantTypes": {
      "implicit": {
	    "loginEndpoint": {
	          "url": "https://api-dev.car.ma/security/oauth/authorize"
	        },
	        "tokenName": "access_token"
	      }
      }
    }
  }
}
	</pre></code>
	</td></tr>
	
	<tr><td>-apiInfoFile</td><td>The path to the json include file that contains the Info that should be included in the generated json. For example for Carma we use: 
	<p></p>
	<p>-apiInfoFile ${project.build.directory}/swagger/includes/apiinfo.json</p>
	
	which includes this content:
	
	<code><pre>
{

    "title": "Carma APIs",
    "description": "<p>This is an interactive API reference for the Carma APIs.</p><p>Below you will see the main sections of the API. Click each section in order to see the endpoints that are available in that category and use the 'Try it out' button to make API calls.</p><p>For endpoints that require authentication you can click the on/off toggle in the top right of the endpoint description, which will take you to a login form.</p><p>If you have not set up a Carma user account already you can do so <a href='https://rtr-dev.car.ma/login' target='_blank'>here</a>.",
    "termsOfServiceUrl": "https://api-dev.car.ma/apidoc/terms.action",
    "contact": "carma-apis@car.ma"

}
	</pre></code>
	</td></tr>
	
	<tr><td>-disableCopySwaggerUi</td><td>If set then this does not copy the swagger ui to the output dir. This can be useful to speed up the doclet and reduce the size of the generated artifact if you either do not use the swagger ui or host or package it separately.</td></tr>
	<tr><td>-swaggerUiZipPath</td><td>If copying of the swagger ui is enabled this is the path to the zip file that includes the ui. If not provided then the default swagger ui embedded in the doclet plugin will be used.</td></tr>
	
	<tr><td>-disableModels</td><td>This turns off generation of models in the documentation.</td></tr>
	
	<tr><td>-crossClassResources</td><td>This is whether to use the cross class resource parser. This parser allows you to have operations of the same resource in different jaxrs Resource classes. NOTE: This parser does not currently support sub resources.</td></tr>
	
	<tr><td>-disableSortApisByPath</td><td>This is whether to disable sorting of apis inside a resource by their path. If not set then they will be ordered by their path. If set then they will be in the order encountered by the parser.</td></tr>
	
	<tr><td>-sortResourcesByPriority</td><td>This is whether the resources in the resource listing e.g. service.json are ordered by their priority as defined by the @resourcePriority tags. Resources without a priorty tag are placed at the bottom. This takes precedence over -sortResourcesByPath. If neither this nor the -sortResourcesByPath options are set then they will be listed in the order encountered by the parser.</td></tr>
	
	<tr><td>-sortResourcesByPath</td><td>This is whether the resources in the resource listing e.g. service.json are ordered by their path. If neither this nor the -sortResourcesByPriority options are set then they will be listed in the order encountered by the parser.</td></tr>
	
	<tr><td>-disableDeprecatedOperationExclusion</td><td>By default operation methods which have either the @deprecated tag or @Deprecated annotation are excluded from the generated documentation. If this flag is set they will be included.</td></tr>
	
	<tr><td>-disableDeprecatedFieldExclusion</td><td>By default model fields which have either the @deprecated tag or @Deprecated annotation (either on the model field or method) are excluded from the generated documentation. If this flag is set they will be included.</td></tr>
	
	<tr><td>-disableDeprecatedParamExclusion</td><td>By default operation parameters which have the @Deprecated annotation are excluded from the generated documentation. If this flag is set they will be included.</td></tr>
	
	<tr><td>-typesToTreatAsOpaque</td><td>This adds additional classes to the set of model classes that are NOT documented. The default set contains org.joda.time.DateTime, java.util.UUID, org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput. Note resteasy multipart is not currently supported by the swagger ui which is why its been left out.</td></tr>
	
	<tr><td>-genericWrapperTypes</td><td>This adds additional classes to the set of model classes that act as genericized wrappers to the actual entity that should be documented. The default set contains com.sun.jersey.api.JResponse.</td></tr>
	
</table>

### Additional Options

These are options that you typically won't need to use unless for example, you want to support different javadoc tags without needing to modify your source code.

<table>
	<tr><th>Option</th><th>Purpose</th></tr>
	
	<tr><td>-excludeParamAnnotations</td><td>This adds additional annotation classes to the set of annotations used to exclude operation parameters from the documentation. The default set contains javax.ws.rs.core.Context</td></tr>
	
	<tr><td>-responseMessageTags</td><td>This adds additional tags to the set of javadoc tags used for response messages. The default set contains responseMessage, status, errorResponse, errorCode, successResponse, successCode. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-excludeOperationTags</td><td>This adds additional tags to the set of javadoc tags used for excluding operations. The default set contains exclude, hide, hidden. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-excludeFieldTags</td><td>This adds additional tags to the set of javadoc tags used for excluding model fields/methods. The default set contains exclude, hide, hidden. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-excludeParamsTags</td><td>This adds additional tags to the set of javadoc tags used for excluding operation parameters. The default set contains excludeParams, hiddenParams, hideParams. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-resourceTags</td><td>This adds additional tags to the set of javadoc tags used for setting the resource that an operation is part of. This only applies to the cross class parser. The default set contains resource, resourcePath, parentEndpointName. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-responseTypeTags</td><td>This adds additional tags to the set of javadoc tags used for setting a custom response model for an operation. The default set contains responseType, outputType. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-inputType</td><td>This adds additional tags to the set of javadoc tags used for setting a custom model for an operation parameter. The default set contains inputType, bodyType. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-defaultErrorType</td><td>This adds additional tags to the set of javadoc tags used to the define the model class to be added to response messages for status codes >= 400. The default set contains defaultErrorType. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-operationSummaryTags</td><td>This adds additional tags to the set of javadoc tags used for setting the summary for an operation. The default set contains summary, endpointName. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-operationNotesTags</td><td>This adds additional tags to the set of javadoc tags used for setting the notes for an operation. The default set contains description, notes, comment. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-fieldDescriptionTags</td><td>This adds additional tags to the list of javadoc tags used for setting the description of model field/methods. The default list contains description, comment, return. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-fieldMinTags</td><td>This adds additional tags to the list of javadoc tags used for setting the min value of a model field. The default list contains min, minimum. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-fieldMaxTags</td><td>This adds additional tags to the list of javadoc tags used for setting the max value of a model field. The default list contains max, maximum. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-resourcePriorityTags</td><td>This adds additional tags to the list of javadoc tags used for setting the priority of a resource for order in the resource listing/service.json. The default list contains resourcePriority, resourceOrder. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-resourceDescriptionTags</td><td>This adds additional tags to the list of javadoc tags used for setting the description of a resource in the esource listing/service.json. The default list contains resourceDescription. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-operationScopeTags</td><td>This adds additional tags to the list of javadoc tags used for setting an oauth2 scope that is required to access an operation. The default list contains scope, oauth2Scope. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-unauthOperationTags</td><td>This adds additional tags to the list of javadoc tags used for indicating an operation does NOT require auhtorization. The default list contains unauthorized, noAuth. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-authOperationTags</td><td>This adds additional tags to the list of javadoc tags used for the alternative way of indicating whether an operation requires or does not require auhtorization. The default list contains authentication, authorization. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-authOperationScopes</td><td>If an operation has "@authentication required" on it then it needs to know which scopes are required. This default set of scopes can be set via this option.</td></tr>
	
	<tr><td>-requiredParamsTags</td><td>This adds additional tags to the list of javadoc tags used for setting whether operation parameters are required. The default list contains requiredParams. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-optionalParamsTags</td><td>This adds additional tags to the list of javadoc tags used for setting whether operation parameters are optional. The default list contains optionalParamsTags. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
	<tr><td>-csvParamsTags</td><td>This adds additional tags to the list of javadoc tags used for setting whether operation parameters are csv/multi valued. The default list contains csvParams. NOTE: The values in the doclet option should NOT have the @ symbol on them.</td></tr>
	
</table>


## Example

An example project using Dropwizard is included in `jaxrs-doclet-sample-dropwizard`. To get it running, run the following commands.

```
$ cd jaxrs-doclet-sample-dropwizard
$ mvn package
$ java -jar target/jaxrs-doclet-sample-dropwizard-0.0.4_carma-SNAPSHOT.jar server sample.yml
```

The example server should be running on port 8080:

```
$ curl localhost:8080/apidocs/service.json
{
  "apiVersion" : "1",
  "basePath" : "/apidocs/",
  "apis" : [ {
    "path" : "/Auth.{format}",
    "description" : ""
  }, {
    "path" : "/HttpServletRequest.{format}",
    "description" : ""
  }, {
    "path" : "/ModelResource_modelid.{format}",
    "description" : ""
  }, {
    "path" : "/Recursive.{format}",
    "description" : ""
  }, {
    "path" : "/Response.{format}",
    "description" : ""
  }, {
    "path" : "/greetings_name.{format}",
    "description" : ""
  } ],
  "swaggerVersion" : "1.2"
}
$
```

## Override Swagger UI

To override the swagger ui included with the doclet, create your own swagger-ui.zip file and add a swaggerUiZipPath to the additionalparam attribute in the pom file.

```
<additionalparam>-apiVersion 1 -docBasePath /apidocs -apiBasePath / -swaggerUiZipPath ../../../src/main/resources/swagger-ui.zip</additionalparam>
```

## New Features/Fixes in this fork:

### Fixes Added or Merged from https://github.com/ryankennedy/swagger-jaxrs-doclet

Issue 73 Support old jackson annotations

Issue 72 (add PUT params to model)  

Issue 71 (return type overriding via doclet tags) 

Issue 70 support parameterized return types and typesToTreatAsOpaque option

Issue 65 Support header params

Issue 64 adding short and char to primitives

Issue 60 various issues such as XmlAccessor apart from the Map value extraction part

Issue 59 resource inheritance

Issue 58 Swagger ui zip path

Issue 52 Model inheritance

Issue 44 Produces/Consumes




### Features

#### Full 1.2 swagger spec support including: 

Authorizations

Info

New data types and formats

Response Messages

Response Message Model

Updated Allowable Values

Produces/Consumes

Model field descriptions

#### Other features:

Support resource operations being spread across multiple resource classes

Support custom/override put/post body model type

support exclude resources/fields (via exclude tags and also via deprecation annotations/tags)













