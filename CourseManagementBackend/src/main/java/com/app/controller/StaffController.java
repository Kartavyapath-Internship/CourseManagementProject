package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.StaffDto;
import com.app.entity.Staff;
import com.app.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	StaffService staffServ ;

	@PostMapping("/add")
	public ResponseEntity<?> addStaff(@RequestBody StaffDto staffDto)
	{
		Staff staff = staffServ.addStaff(staffDto);
		return ResponseEntity.ok(staff);
	}
	
	@PutMapping("/update/{staffId}")
	public ResponseEntity<?> updateStaff(@RequestBody StaffDto staffDto , @PathVariable int staffId)
	{
		Staff staff = staffServ.updateeStaff(staffDto, staffId);
		return ResponseEntity.ok(staff);
	}
	
	@DeleteMapping("/{staffId}")
	public ResponseEntity<?> deleteStaff(@PathVariable int staffId)
	{
		String msg = staffServ.deleteStaff(staffId);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAllStaff()
	{
		List<Staff> list = staffServ.getAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{staffId}")
	public ResponseEntity<?> getStaff(@PathVariable int staffId)
	{
		Staff staff = staffServ.getStaffStaff(staffId);
		return ResponseEntity.ok(staff);
	}

}
