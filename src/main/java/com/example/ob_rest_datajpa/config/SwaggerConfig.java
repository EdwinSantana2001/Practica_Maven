package com.example.ob_rest_datajpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {
   @Bean
   public Docket api(){
      return new Docket(DocumentationType.SWAGGER_2).
              apiInfo(apiDetails()).
              select().
              apis(RequestHandlerSelectors.any()).
              paths(PathSelectors.any())
              .build();
}
public ApiInfo apiDetails(){
      return new ApiInfo("Spring Boot Book API REST",
              "Libray Api rest Docs",
              "1.0","MIT",
              new Contact("Edwin Santana","https://campus.open-bootcamp.com/cursos/14/leccion/350","edwin@example.com"),
              "MIT",
              "https://campus.open-bootcamp.com/cursos/14/leccion/350",
              Collections.emptyList());
}
}
