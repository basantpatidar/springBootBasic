package com.spring.boot.app.rest;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.app.model.GetUserDTO;
import com.spring.boot.app.model.SignupDTO;
import com.spring.boot.app.service.SignupService;

@Singleton
@RestController
public class SignupFormRest {
	@Autowired 
	private SignupService signupService;
	@RequestMapping(value="/signup" , method= RequestMethod.POST)
	public SignupDTO signupUser(@RequestBody SignupDTO signup) {
		signupService.createSignup(signup);
		return signup;
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET)
	public SignupDTO getUser(@RequestParam("id") long id) {
		SignupDTO gud = signupService.getUserDetails(id);
		return gud;
	}
	
	@RequestMapping(value="updateUser", method = RequestMethod.POST)
	public SignupDTO updateUser(@RequestBody SignupDTO signup) {
		SignupDTO gud = signupService.updateUser(signup);
		return gud;
	}

//	"Basant","Patidar","b@p.com","basantpatidar","aabb"

	
}
