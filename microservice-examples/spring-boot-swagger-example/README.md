# Spring boot swagger example
This project contains an example on how to get [Swagger Spec](https://github.com/swagger-api/swagger-spec) style information from a [Spring Boot REST Service](https://spring.io/guides/gs/rest-service/).

### Adding swagger
In order to activate swagger for a spring boot application follow these steps:

####Add Swagger dependency
The first step is to add the swagger-spring-mvc dependency. E.g maven:

	<dependency>
		<groupId>com.mangofactory</groupId>
		<artifactId>swagger-springmvc</artifactId>
		<version>1.0.2</version>
	</dependency>

#### Add swagger config
The easiest way to enable swagger is to just add the

	@EnableSwagger

annotiation to the Spring boot application:

	@RestController
	@EnableAutoConfiguration
	@ComponentScan
	@EnableSwagger
	public class SwaggerSpringBootSampleApplication {
	
		@RequestMapping("/helloworld")
		String home() {
			return "Hello World!";
		}
	
		@RequestMapping(method = RequestMethod.GET, value = "/customer/{id}")
		Customer customer(@PathVariable String id) {
			return this.getCustomer(id);
		}
	
		public static void main(String[] args) throws Exception {
			SpringApplication.run(SwaggerSpringBootSampleApplication.class, args);
		}
	
		...
	}

After adding this annotation the URL

[http://localhost:8080/api-docs](http://localhost:8080/api-docs) 

basic info about the api will be displayed:

	{
	  "apiVersion" : "1.0",
	  "apis" : [ {
	    "description" : "Basic Error Controller",
	    "path" : "/default/basic-error-controller",
	    "position" : 0
	  }, {
	    "description" : "Swagger Spring Boot Sample Application",
	    "path" : "/default/swagger-spring-boot-sample-application",
	    "position" : 0
	  } ],
	  "authorizations" : { },
	  "info" : {
	    "contact" : "Contact Email",
	    "description" : "Api Description",
	    "license" : "Licence Type",
	    "licenseUrl" : "License URL",
	    "termsOfServiceUrl" : "Api terms of service",
	    "title" : "default Title"
	  },
	  "swaggerVersion" : "1.2"
	}

The detailed swagger information about the api can in this case be accessed using the URL

[http://localhost:8080/api-docs/default/swagger-spring-boot-sample-application](http://localhost:8080/api-docs/default/swagger-spring-boot-sample-application)

If you do not wish to give any more information about your API you can stop here. If you opt to publish more information you may find the next step useful.


###Links for reference
- How to set date format for REST/Jackson REST services:

[http://wiki.fasterxml.com/JacksonFAQDateHandling](http://wiki.fasterxml.com/JacksonFAQDateHandling) 

- JavaDoc of the configuration for Jackson:

[http://fasterxml.github.io/jackson-databind/javadoc/2.0.0/com/fasterxml/jackson/databind/SerializationFeature.html](http://fasterxml.github.io/jackson-databind/javadoc/2.0.0/com/fasterxml/jackson/databind/SerializationFeature.html)
[http://fasterxml.github.io/jackson-databind/javadoc/2.0.0/com/fasterxml/jackson/databind/MapperFeature.html](http://fasterxml.github.io/jackson-databind/javadoc/2.0.0/com/fasterxml/jackson/databind/MapperFeature.html)
[http://fasterxml.github.io/jackson-databind/javadoc/2.0.0/com/fasterxml/jackson/databind/DeserializationFeature.html](http://fasterxml.github.io/jackson-databind/javadoc/2.0.0/com/fasterxml/jackson/databind/DeserializationFeature.html) 