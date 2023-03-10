package com.example.crud_operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2

@EnableEurekaClient
@SpringBootApplication
public class CrudOperationsApplication {

  public static void main(String[] args) {

    SpringApplication.run(CrudOperationsApplication.class, args);
  }

  @Bean
  public Docket couponApi() {

    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.example.productservice")).build();
  }

}
