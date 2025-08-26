package com.app.service;

import java.util.List;

import com.app.dto.StaffDto;
import com.app.entity.Staff;

public interface StaffService {

	Staff addStaff(StaffDto staffDto);

	Staff updateeStaff(StaffDto staffDto, int staffId);

	String deleteStaff(int staffId);

	List<Staff> getAll();

	Staff getStaffStaff(int staffId);
	
	
}
