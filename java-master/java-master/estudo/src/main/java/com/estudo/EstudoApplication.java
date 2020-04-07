package com.estudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.estudo"})
public class EstudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoApplication.class, args);
	}

}
