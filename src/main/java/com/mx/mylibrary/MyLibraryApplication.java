package com.mx.mylibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.mx.mylibrary.entity" })
@EnableJpaRepositories(basePackages = {"com.mx.mylibrary.repository"})
public class MyLibraryApplication {

    private static Class MAIN_CLASS = MyLibraryApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(MAIN_CLASS,args);
    }
}
