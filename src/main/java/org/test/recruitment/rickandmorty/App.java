package org.test.recruitment.rickandmorty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@ConfigurationProperties
@ComponentScan("org.test.recruitment.rickandmorty")
@OpenAPIDefinition
public class App {
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}