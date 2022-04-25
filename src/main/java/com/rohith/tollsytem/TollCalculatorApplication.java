package com.rohith.tollsytem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EntityScan(basePackages = {"com.rohith.tollsystem.entity"})
@ComponentScan("com.rohith.tollsystem.*")  
@SpringBootApplication
@Configuration
@EnableConfigurationProperties
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.rohith.tollsystem.repository"})
public class TollCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollCalculatorApplication.class, args);
	}

	
	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.rohith.tollsystem.controller")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("TOLLSYSTEM REST API DOCUMENTS").description("Documents with Swagger 2")
				.termsOfServiceUrl("http://localhost").license("").licenseUrl("")
				.version("1.0").build();
	}
}
