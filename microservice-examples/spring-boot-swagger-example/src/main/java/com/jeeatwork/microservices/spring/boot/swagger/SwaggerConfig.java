package com.jeeatwork.microservices.spring.boot.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		SwaggerSpringMvcPlugin swaggerSpringMvcPlugin= new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(
				apiInfo()).includePatterns("/customer/.*");
		return swaggerSpringMvcPlugin;
		
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Swagger Spring MVC Sample Api",
				"Sample application demonstrating how to use swagger-springmvc",
				"http://en.wikipedia.org/wiki/Terms_of_service",
				"tom1299@jjeatwork.com", "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0.html");
	}
}