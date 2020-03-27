package com.spring.boot.app.rest;

import javax.inject.Singleton;

import org.springframework.web.bind.annotation.RestController;

@Singleton
@RestController
public class SignupFormRest {
	@RequestMapping(value="/signup" , method= RequestMethod.POST)
	
}
