package com.spring.boot.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.app.adaptor.SignupAdaptor;
import com.spring.boot.app.dao.SignupRepository;
import com.spring.boot.app.entity.UserEntity;
import com.spring.boot.app.model.SignupDTO;

@Service
public class SignupService {
	
	@Autowired
	private SignupRepository signupRepository;

	public SignupDTO createSignup(SignupDTO signup) {
		
		UserEntity se = SignupAdaptor.dtoToEntity(signup);
		
		signupRepository.save(se);
		
		return signup;
	}
	
	public SignupDTO getUserDetails(long id ) {
			
//			GetUserDTO gud = SignupAdaptor.convertEntityToDTO(userEntity);
		
			Optional<UserEntity> user = signupRepository.findById(id);
			
			UserEntity ue = user.get();
						
			SignupDTO gud = SignupAdaptor.convertEntityToDTO(ue);
			
			return gud;
			
		}
	
	public SignupDTO updateUser(SignupDTO signup) {
		
		UserEntity se = SignupAdaptor.dtoToEntity(signup);
		
		signupRepository.save(se);
		
		return signup;
	}
	
	public void deleteUser(long id) {
		signupRepository.deleteById(id);
	}
	
	public List<SignupDTO> getUsers( ) {
		
//		GetUserDTO gud = SignupAdaptor.convertEntityToDTO(userEntity);
		List<SignupDTO> users = new ArrayList<SignupDTO>();
		List<UserEntity> userList = signupRepository.findAll();
		
		for(UserEntity user : userList)
			users.add(SignupAdaptor.entityToDTO(user));
		
		return users;
		
	}
	
	public List<SignupDTO> getByUsername(String username) {
			
		List<SignupDTO> signup = new ArrayList<SignupDTO>();
		
		List<UserEntity> userentity = new ArrayList<UserEntity>();

		userentity = signupRepository.findByUsername1(username);
		
		for(UserEntity user : userentity) {
			signup.add(SignupAdaptor.entityToDTO(user));
		}
			
			return signup;
		}
	
}
