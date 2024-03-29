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
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET)
	public MappingJacksonValue getUser(@RequestParam("id") long id, @RequestParam("filter") Set<String> filter) {
		MappingJacksonValue gud = null;
		try {
			 gud = signupService.getUserDetails(id, filter);
		}catch(UserNotFoundException unf) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,unf.getMessage());
		}
		return gud;
	}
	
	@RequestMapping(value="/filter/getUser", method=RequestMethod.GET)
	public MappingJacksonValue getUserFilter(@RequestParam("id") long id, HttpServletRequest request) {
		MappingJacksonValue gud = null;
		try {
			 gud = signupService.getUserDetails(id, null);
		}catch(UserNotFoundException unf) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,unf.getMessage());
		}
		return gud;
	}
	
	@RequestMapping(value="/getUserOne", method=RequestMethod.GET)
	public SignupDTO getUser1(@RequestParam("id") long id) {
		SignupDTO gud = null;
		/*try {*/
			 gud = signupService.getUserDetails1(id);
		/*
		 * }catch(UserNotFoundException unf) { throw new
		 * ResponseStatusException(HttpStatus.NOT_FOUND,unf.getMessage()); }
		 */
		return gud;
	}
	
	@RequestMapping(value="/updateUser", method = RequestMethod.PUT)
	public SignupDTO updateUser(@RequestBody SignupDTO signup) {
		SignupDTO gud = null;
		try {
			 gud = signupService.updateUser(signup);
		}catch(UserNotFoundException unf) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,unf.getMessage());
		}
		return gud;
	}
	
	@RequestMapping(value="/deleteUser", method = RequestMethod.DELETE)
	public String deleteUser(@RequestParam("id") long id) {
		try{
	signupService.deleteUser(id);	
		}catch(UserNotFoundException unf) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, unf.getMessage());
		}
		return messageSource.getMessage("label.delete", null, LocaleContextHolder.getLocale());
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	public List<SignupDTO> getUser() throws UserNotFoundException{
		List<SignupDTO> userList = signupService.getUsers();
		return userList;
	}
	
	@RequestMapping(value="/getUsersTest", method=RequestMethod.GET)
	public String[] getUserTest() throws UserNotFoundException{
		String username = "RAM";
		String[] names = {};
		return names;
	}
	
	@RequestMapping(value="/getByUsername", method=RequestMethod.GET)
	public SignupForm getByUsername(@RequestParam("username") String username) throws Exception{
		List<SignupDTO> user = new ArrayList<SignupDTO>();
		SignupForm form = null;
		/* try { */
			user = signupService.getByUsername(username);
			//form = new SignupForm(null, user,null);
		/*}catch(Exception exp) {
			form = new SignupForm(null, null, exp);
		}*/
		return form;
	}
	
	/*
	 * @RequestMapping(value="/count", method=RequestMethod.GET) public Long
	 * totalCount() { return signupService.userCount();
	 * 
	 * }
	 */
	
	/*
	 * @RequestMapping(value="/search", method=RequestMethod.GET) public Long
	 * totalTargetCount(@RequestParam("target") String targetType){ Long count =
	 * SignupService.totalTargetCount(targetType); return count;
	 * 
	 * }
	 */
	
	@RequestMapping("/i18")
	public String i18(@RequestHeader("Accept-Language") String locale) {
		return messageSource.getMessage("label.hello", null, new Locale(locale));
		
	}
	
	@RequestMapping("/i181")
	public String i181() {
		return messageSource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}
}
