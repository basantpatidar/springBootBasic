package com.spring.boot.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.boot.app.adaptor.SignupAdaptor;
import com.spring.boot.app.dao.SignupRepository;
import com.spring.boot.app.entity.UserEntity;
import com.spring.boot.app.exception.UserExistException;
import com.spring.boot.app.exception.UserNotFoundException;
import com.spring.boot.app.model.SignupDTO;

@Service
public class SignupService {

	@Autowired
	private SignupRepository signupRepository;

	public SignupDTO createSignup(SignupDTO signup) throws UserExistException {

		UserEntity se = SignupAdaptor.dtoToEntity(signup);
	
		List<UserEntity> ue =  signupRepository.findByUsername(signup.getUsername());
		System.out.println(ue.toString());
		if(null != ue && !ue.isEmpty()) {
			throw new UserExistException("User Already Exists");
		}
		signupRepository.save(se);

		return signup;
	}

	public MappingJacksonValue getUserDetails(long id, Set<String> fields)  {

//			GetUserDTO gud = SignupAdaptor.convertEntityToDTO(userEntity);

		Optional<UserEntity> user = signupRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not available with given ID. Please provide proper ID");
		}

		UserEntity ue = user.get();
		SignupDTO gud = SignupAdaptor.convertEntityToDTO(ue);
		
		/*
		 * Set<String> fileds = new HashSet<String>(); fileds.add("username");
		 * fileds.add("firstName");
		 */
		SimpleFilterProvider filter = new SimpleFilterProvider();
				filter.addFilter("signupFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
		MappingJacksonValue mapper = new MappingJacksonValue(gud);
		mapper.setFilters(filter);

		return mapper;
		
		//return gud;

	}
	
	public SignupDTO getUserDetails1(long id)  {

//		GetUserDTO gud = SignupAdaptor.convertEntityToDTO(userEntity);

	Optional<UserEntity> user = signupRepository.findById(id);
	
	if(!user.isPresent()) {
		throw new UserNotFoundException("User not available with given ID. Please provide proper ID");
	}

	UserEntity ue = user.get();

	SignupDTO gud = SignupAdaptor.convertEntityToDTO(ue);

	return gud;

}

	public SignupDTO updateUser(SignupDTO signup) throws UserNotFoundException{

		UserEntity se = SignupAdaptor.dtoToEntity(signup);
		
		Optional<UserEntity> user = signupRepository.findById(signup.getId());
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not available with given ID. Please provide proper ID");
		}
		signupRepository.save(se);

		return signup;
	}

	public void deleteUser(long id) throws UserNotFoundException{
//		boolean isDeleted = false;
		Optional<UserEntity> user = signupRepository.findById(id);
		if(user.isEmpty()) {
			throw new UserNotFoundException("User not present");
		}
		signupRepository.deleteById(id);
	}

	public List<SignupDTO> getUsers() throws UserNotFoundException{

//		GetUserDTO gud = SignupAdaptor.convertEntityToDTO(userEntity);
		List<SignupDTO> users = new ArrayList<SignupDTO>();
		List<UserEntity> userList = signupRepository.findAll();
		if(userList.isEmpty()) {
			throw new UserNotFoundException("There are no users in Record");
		}

		for (UserEntity user : userList)
			users.add(SignupAdaptor.entityToDTO(user));

		return users;

	}

	public List<SignupDTO> getByUsername(String username) throws Exception {

		List<SignupDTO> signup = new ArrayList<SignupDTO>();

		List<UserEntity> userentity = new ArrayList<UserEntity>();
		
		/* try { */
			userentity = signupRepository.findByUsername(username);

			for (UserEntity user : userentity) {
				signup.add(SignupAdaptor.entityToDTO(user));
			}
		/*}catch(Exception exp) {
			throw new MyException(HttpStatus.INTERNAL_SERVER_ERROR,"Due to INTERNAL SERVER ERROR, we're unable to process your request. Kindly try afer some time.",null, "ERROR");
		}*/
		return signup;
	}
	
	/*
	 * public Long userCount() { return signupRepository.count(); }
	 * 
	 * public Long totalTargetCount(targetType){ return
	 * signupRepository.count(targetType); }
	 */
}
