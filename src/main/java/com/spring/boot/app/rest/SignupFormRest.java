package com.spring.boot.app.rest;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.app.model.SignupDTO;
import com.spring.boot.app.service.SignupService;

@Singleton
@RestController
public class SignupFormRest {
	@Autowired 
	private SignupService signupService;
	@RequestMapping(value="/signup" , method= RequestMethod.POST)
	public SignupDTO signup(@RequestBody SignupDTO signup) {
		signupService.createSignup(signup);
		return signup;
	}

//	"Basant","Patidar","b@p.com","basantpatidar","aabb"

	
}
