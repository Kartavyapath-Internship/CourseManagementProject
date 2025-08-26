package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginResponse;
import com.app.entity.Staff;
import com.app.service.StaffService;

@RestController
@RequestMapping("/login")
public class LoginController {
	 @Autowired
	    private StaffService staffService;

	    @PostMapping
	    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
	        return ResponseEntity.ok("");
	    }
}
