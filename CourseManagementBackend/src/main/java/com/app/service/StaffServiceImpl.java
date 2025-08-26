package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RoleDao;
import com.app.dao.StaffDao;
import com.app.dto.StaffDto;
import com.app.entity.Role;
import com.app.entity.Staff;

@Service
public class StaffServiceImpl implements StaffService {
	
	@Autowired
	StaffDao staffDao ;
	
	@Autowired
	RoleDao roleDao ;

	@Override
	public Staff addStaff(StaffDto staffDto) {
		
		Role role = roleDao.findById(staffDto.getRoleID()).orElseThrow(()-> new RuntimeException("Role not found"));
		
		Staff staff = new Staff(staffDto.getName(), staffDto.getPassword(), staffDto.getMobileNo(), staffDto.getEmail(), staffDto.getStaffType(), role);
		
		return staffDao.save(staff);
	}

	@Override
	public Staff updateeStaff(StaffDto staffDto, int staffId) {
		
		Staff staff  = staffDao.findById(staffId).orElseThrow(()-> new RuntimeException("staff not found"));
		
		Role role = roleDao.findById(staffDto.getRoleID()).orElseThrow(()-> new RuntimeException("Role not found"));
		
		staff.setName(staffDto.getName());
	    staff.setPassword(staffDto.getPassword());
	    staff.setMobileNo(staffDto.getMobileNo());
	    staff.setEmail(staffDto.getEmail());
	    staff.setStaffType(staffDto.getStaffType());
	    staff.setRole(role);
		
		return staffDao.save(staff);
	}

	@Override
	public String deleteStaff(int staffId) {
		
		Staff staff  = staffDao.findById(staffId).orElseThrow(()-> new RuntimeException("staff not found"));

		staffDao.delete(staff);
		
		return "Staff deleted successfully";
	}

	@Override
	public List<Staff> getAll() {
		return staffDao.findAll();
	}

	@Override
	public Staff getStaffStaff(int staffId) {
		
		Staff staff  = staffDao.findById(staffId).orElseThrow(()-> new RuntimeException("staff not found"));
		
		return staff;
	}
	
	
}
