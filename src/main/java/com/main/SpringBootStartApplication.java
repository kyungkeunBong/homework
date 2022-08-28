package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);
	}
	@GetMapping("/test")
	public String hello() {
		return "HHHHHello";
	}
}
