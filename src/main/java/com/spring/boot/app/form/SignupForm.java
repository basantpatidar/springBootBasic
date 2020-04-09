package com.spring.boot.app.form;

import java.io.Serializable;
import java.util.List;

import com.spring.boot.app.model.SignupDTO;

public class SignupForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SignupDTO signupDTO;
	private List<SignupDTO> list;
	//private MyException exp;
	
	public SignupForm(SignupDTO signupDTO, List<SignupDTO> list) {
		super();
		this.signupDTO = signupDTO;
		this.list = list;
	}

	public SignupDTO getSignupDTO() {
		return signupDTO;
	}

	public void setSignupDTO(SignupDTO signupDTO) {
		this.signupDTO = signupDTO;
	}

	public List<SignupDTO> getList() {
		return list;
	}

	public void setList(List<SignupDTO> list) {
		this.list = list;
	}

	/*
	 * public MyException getExp() { return exp; }
	 * 
	 * public void setExp(MyException exp) { this.exp = exp; }
	 */
	
	
	
	
}
