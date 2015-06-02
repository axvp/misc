# Swagger example
This example demonstrates the usage of the [swagger ui](http://editor.swagger.io/#/) for creating client api from swagger json.

### Swagger maven plugin
The [swagger maven plugin](https://github.com/kongchen/swagger-maven-plugin) can be used to generate swagger json from annotated class files.

### Generating java code
In order to generate java code from a swagger json the [swagger-codegen](https://github.com/swagger-api/swagger-codegen.git) can be used.

### Command for generating Java code:
	java -jar ../../../swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate -i ./helloWorld.json -l java -o ./java

### Command for generating Spring-MVC code:
	java -jar ../../../swagger-codegen/modules/swagger-codegen-cli/target/swagger-codegen-cli.jar generate -i ./helloWorld.json -l java -o ./spring-mvc