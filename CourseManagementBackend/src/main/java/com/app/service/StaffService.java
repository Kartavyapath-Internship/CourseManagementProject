package com.app.service;

import com.app.dto.LoginResponse;
import com.app.entity.Staff;

public interface StaffService {
	 LoginResponse login(String email, String password);
}
