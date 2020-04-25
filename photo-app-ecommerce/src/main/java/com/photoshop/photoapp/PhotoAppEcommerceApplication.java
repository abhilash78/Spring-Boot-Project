package com.photoshop.photoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.photoshop.photoapp.security.AppProperties;

@SpringBootApplication
public class PhotoAppEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppEcommerceApplication.class, args);
	}

	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public SpringApplicationContext springApplicationContext()
	{
		return new SpringApplicationContext();
	}
	
	
	@Bean 
	public AppProperties AppProperties()
	{
		return new AppProperties();
	}
}
