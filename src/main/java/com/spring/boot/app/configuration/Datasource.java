package com.spring.boot.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Datasource {
	
	
	@Bean
	@Profile("prod")
	public String prodDataSource() {
		return "DB connection for PROD";
	}
	
	@Bean
	@Profile("qa")
	public String qaDataSource() {
		return "DB connection for QA";
	}
	
	@Bean
	@Profile("test")
	public String testDataSource() {
		return "DB connection for Test";
	}
}
