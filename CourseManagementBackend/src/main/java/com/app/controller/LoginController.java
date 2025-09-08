package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginResponse;
import com.app.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	 @Autowired
	    private LoginService loginService;	 

	    @PostMapping
	    public ResponseEntity<LoginResponse> login(@RequestParam String email, @RequestParam String password) {
	        return ResponseEntity.ok(loginService.login(email, password));
	    }
}
