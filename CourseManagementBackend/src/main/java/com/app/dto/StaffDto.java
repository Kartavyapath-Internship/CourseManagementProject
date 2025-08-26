package com.app.dto;

import com.app.entity.enums.StaffType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {

	private String name;
	
	private String password;
	
	private String mobileNo;
	
	private String email;
	
	private StaffType staffType;
	
	private int roleID;
}
