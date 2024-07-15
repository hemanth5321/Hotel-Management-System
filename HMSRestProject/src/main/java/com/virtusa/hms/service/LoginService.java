package com.virtusa.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.hms.dao.EmpCredRepository;
import com.virtusa.hms.dto.EmpCredDTO;

@Service
public class LoginService {

	@Autowired
	EmpCredRepository dao;
	
	public String validate(String email, String password) {
		EmpCredDTO l = dao.getAuth(email, password);
		if (l == null)
			return "Invalid Username or Password";
		else
			return"Login Successfull";
	}
}
