package com.spring.boot.app;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringBootBasicsApplication {
	
	

	public static void main(String[] args) {
//		ConfigurableApplicationContext context = SpringApplication.run(SpringBootBasicsApplication.class, args);
		SpringApplication.run(SpringBootBasicsApplication.class, args);
		}
	
	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver locale = new AcceptHeaderLocaleResolver();
		locale.setDefaultLocale(Locale.ENGLISH);
		return locale;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	

}
