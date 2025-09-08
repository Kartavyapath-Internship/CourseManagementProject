package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StaffDao;
import com.app.dto.LoginResponse;
import com.app.entity.Staff;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
    private StaffDao staffDao;

    @Override
    public LoginResponse login(String email, String password) {
        Staff staff = staffDao.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        return new LoginResponse(
                staff.getId(),
                staff.getName(),
                staff.getEmail(),
                staff.getMobileNo(),
                staff.getStaffType(),
                staff.getRole()
        );
    }

}
