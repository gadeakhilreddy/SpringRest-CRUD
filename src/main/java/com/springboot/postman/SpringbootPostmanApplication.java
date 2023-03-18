package com.springboot.postman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.springboot.postman.model"})
public class SpringbootPostmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootPostmanApplication.class, args);
	}

}
