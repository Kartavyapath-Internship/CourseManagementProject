package com.app.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CertificateRespDto {

	private int id ;
	
	private String content ;
	
	private String courseName ;
	
	private List<ImageRespDto> imgs ;
	
}
