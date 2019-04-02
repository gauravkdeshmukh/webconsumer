package com.featureflags.webconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class WebconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebconsumerApplication.class, args);
	}

}
