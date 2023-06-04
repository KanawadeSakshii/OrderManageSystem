package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class OrderManagementSystem1Application {
	private static final Logger logger = LoggerFactory.getLogger(OrderManagementSystem1Application.class);

	public static void main(String[] args) {
		logger.info("Application Started ");
		SpringApplication.run(OrderManagementSystem1Application.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis((Predicate<RequestHandler>) RequestHandlerSelectors.any())
				.paths((Predicate<String>) PathSelectors.any()).build();
	}
	}
