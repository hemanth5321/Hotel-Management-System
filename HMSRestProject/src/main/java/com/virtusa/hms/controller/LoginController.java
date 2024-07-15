package com.virtusa.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.hms.service.LoginService;

@RestController
@RequestMapping("Login")
public class LoginController {

	@Autowired
	LoginService service;
	
	@GetMapping("/email/{email}/password/{password}")
	public String validate(@PathVariable String email,@PathVariable String password) {
		return service.validate(email,password);
	}
}
