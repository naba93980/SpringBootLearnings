package com.nabajyoti.springboot.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nabajyoti.springboot.tutorial" )
public class SpringBootTutorialApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

}
