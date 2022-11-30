package org.test.recruitment.rickandmorty;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	
    public static void main(String[] args) {
    	LOGGER.info("init app spring boot");
        SpringApplication.run(App.class, args);
    }
    
    @PostConstruct
    public void postConstruct() {
    	LOGGER.info("app started!");
    }
}