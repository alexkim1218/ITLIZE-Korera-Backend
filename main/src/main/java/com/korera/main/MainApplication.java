package com.korera.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("Controller")
public class MainApplication {

	public static void main(String[] args) {
//		test slack 2
		SpringApplication.run(MainApplication.class, args);
	}

}
