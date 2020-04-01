package com.spring.boot.app.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.app.exception.MyException;
import com.spring.boot.app.form.SignupForm;
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
	
	@RequestMapping(value="/updateUser", method = RequestMethod.PUT)
	public SignupDTO updateUser(@RequestBody SignupDTO signup) {
		SignupDTO gud = signupService.updateUser(signup);
		return gud;
	}

	@RequestMapping(value="/deleteUser", method = RequestMethod.DELETE)
	public void deleteUser(@RequestParam("id") long id) {
	signupService.deleteUser(id);	
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<SignupDTO> getUser() {
		List<SignupDTO> userList = signupService.getUsers();
		return userList;
	}

	@RequestMapping(value="/getByUsername", method=RequestMethod.GET)
	public SignupForm getByUsername(@RequestParam("username") String username){
		List<SignupDTO> user = new ArrayList<SignupDTO>();
		SignupForm form = null;
		try {
			user = signupService.getByUsername(username);
			form = new SignupForm(null, user,null);
		}catch(MyException exp) {
			form = new SignupForm(null, null, exp);
		}
		return form;
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET)
	public Long totalCount() {
		return signupService.userCount();
		
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public Long totalTargetCount(@RequestParam("target") String targetType){
		Long count = SignupService.totalTargetCount(targetType);
		return count;
		
	}
	
}
