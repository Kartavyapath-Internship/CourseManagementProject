package com.app.dto;

import com.app.entity.enums.StaffType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	 private Integer id;
	    private String name;
	    private String email;
	    private String mobileNo;
	    private StaffType staffType;
	  //  private Role role;
}
