package com.app.service;

import org.springframework.stereotype.Service;

import com.app.dto.LoginResponse;


public interface LoginService {
	LoginResponse login(String email, String password);
}
