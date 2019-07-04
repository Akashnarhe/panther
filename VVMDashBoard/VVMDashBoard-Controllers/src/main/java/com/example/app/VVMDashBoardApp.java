package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaRepositories(basePackages="com.example")
@EntityScan(basePackages="com.example")
@SpringBootApplication(scanBasePackages="com.example")
public class VVMDashBoardApp {
	
	public static void main(String[] args){
		SpringApplication.run(VVMDashBoardApp.class, args);
	}
	
}
