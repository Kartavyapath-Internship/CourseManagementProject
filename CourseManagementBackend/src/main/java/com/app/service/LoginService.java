package com.app.service;

import com.app.dto.LoginResponse;

public interface LoginService {
	LoginResponse login(String email, String password);
}
