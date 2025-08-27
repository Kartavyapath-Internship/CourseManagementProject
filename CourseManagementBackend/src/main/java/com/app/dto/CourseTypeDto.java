package com.app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseTypeDto {

	private Integer id;

	private String title;

	private String description;
	
	private List<CourseSummaryDto> courses;
	
	
	
}