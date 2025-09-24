package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.StaffDao;
import com.app.dto.LoginRequest;
import com.app.dto.LoginResponse;
import com.app.dto.ResetPasswordRequest;
import com.app.dto.LoginResponse;
import com.app.dto.StaffReqDto;
import com.app.dto.StaffRespDto;
import com.app.entity.Staff;
import com.app.service.LoginService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
@Slf4j
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private StaffDao staffDao;
	
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	
	 // ------------------ Login -------------------
    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    	
    	log.error("Email Id {} and paswword {}",request.getEmail(),request.getPassword() );
    	
    	System.out.println("email id is "+request.getEmail());
        LoginResponse response = loginService.login(request);
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
    	log.error("Email Id {} and paswword {}",request.getEmail(),request.getNewPassword() );
    	
    	Optional<Staff> staff = staffDao.findByEmail(request.getNewPassword());
    	
    	log.error("Email Id {} and paswword {}",staff.get().getEmail(),staff.get().getPassword() );
    	
        return staffDao.findByEmail(request.getEmail())
                .map(user -> {
                    // ✅ Encode and update password
                    user.setPassword(passwordEncoder.encode(request.getNewPassword()));
                    System.out.println(request.getNewPassword());
                    staffDao.save(user);
                    return ResponseEntity.ok("Password reset successfully!");
                })
                .orElseGet(() -> ResponseEntity.status(404).body("User not found with this email."));
    }
}