package com.spring.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {
	
	@Bean
	Contact contact()
	{
		return new Contact().name("Jack")
							.email("manikgantait2001@gmail.com")
							.url("xyz.in");
				
	}
	
	@Bean
	Info info()
	{
		return new Info().title("Product Management system")
						.description("RESTfull API with basic CURD opeartion.")
						.version("V1")
						.contact(contact());
	}
	@Bean
	OpenAPI openAPI()
	{
		return new OpenAPI().info(info());
	}

}
