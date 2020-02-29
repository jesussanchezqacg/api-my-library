package com.mx.mylibrary.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mx.mylibrary"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(getApiInfo())
                .directModelSubstitute(Timestamp.class,Long.class)
                .consumes(getConsumes())
                .produces(getProduces());
    }

    private Set<String> getConsumes() {
        Set<String> consumes = new HashSet<>();
        consumes.add(MediaType.APPLICATION_JSON_VALUE);
        consumes.add(MediaType.APPLICATION_JSON_UTF8_VALUE);
        return consumes;
    }

    private Set<String> getProduces() {
        Set<String> produces = new HashSet<>();
        produces.add(MediaType.APPLICATION_JSON_VALUE);
        produces.add(MediaType.APPLICATION_JSON_UTF8_VALUE);
        return produces;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "My Library",
                "Api RESTFul - My Library",
                "1.0.0",
                "TERMS OF SERVICE URL",
                new Contact("Quality & Knowledge on IT Services","URL","EMAIL"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
