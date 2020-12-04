package com.spring.boot.app.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.boot.app.exception.UserExistException;
import com.spring.boot.app.exception.UserNotFoundException;
import com.spring.boot.app.form.SignupForm;
import com.spring.boot.app.model.SignupDTO;
import com.spring.boot.app.service.SignupService;

@Singleton
@RestController
public class SignupFormRest {
	///a & b = a-> b -> a
	@Autowired
	ResourceBundleMessageSource messageSource ;
	
	
	 private SignupService signupService ;
	
	
	@Autowired
	SignupFormRest(SignupService signupService){
		this.signupService = signupService;
	}
	
	@RequestMapping(value="/signup" , method= RequestMethod.POST)
	public MappingJacksonValue signupUser(@RequestBody SignupDTO signup) {
		MappingJacksonValue gud = null;
		try {
			System.out.println(signup.toString());
		 gud = signupService.createSignup(signup);
		}catch(UserExistException uee) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, uee.getMessage());
		}
		return gud;
	}
	
}
