package com.spring.boot.app.adaptor;

import com.spring.boot.app.entity.UserEntity;
import com.spring.boot.app.model.SignupDTO;

public class SignupAdaptor {
	
	public static SignupDTO entityToDTO(UserEntity se) {
	SignupDTO signup = new SignupDTO();
	
	signup.setId(se.getId());
	signup.setFirstName(se.getFirstName());
	signup.setLastName(se.getLastName());
	signup.setEmailAddress(se.getEmailAddress());
	signup.setUsername(se.getUsername());
	signup.setPassword(se.getPassword());
	
	return signup;
	}
	
	
	public static UserEntity dtoToEntity(SignupDTO signup) {
		
//		SignupDTO signup = new SignupDTO(se.getFirstName(), se.getLastName(), se.getEmailAddress(), se.getUsername(), se.getPassword());
		
		UserEntity se = new UserEntity();
		
		se.setId(signup.getId());
		se.setFirstName(signup.getFirstName());
		se.setLastName(signup.getLastName());
		se.setEmailAddress(signup.getEmailAddress());
		se.setUsername(signup.getUsername());
		se.setPassword(signup.getPassword());
		
		return se;
	}
	
	public static SignupDTO convertEntityToDTO(UserEntity userEntity) {
			
		SignupDTO getUserdto = new SignupDTO();
			
			getUserdto.setFirstName(userEntity.getFirstName());
			getUserdto.setLastName(userEntity.getLastName());
			getUserdto.setEmailAddress(userEntity.getEmailAddress());
			getUserdto.setUsername(userEntity.getUsername());
			
			return getUserdto;
		
	}

}
