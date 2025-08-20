package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.CourseTypeDto;
import com.app.entity.CourseType;


public interface CourseTypeService {

	// create

	public CourseType createCourseType(CourseTypeDto courseTypeDto);

	// update

	public CourseType updateCourseType(Integer courseTypeId, CourseTypeDto courseTypeDto);

	// delete

	public void deleteCourseType(Integer courseTypeId);

	// find CourseTypeById

	public CourseType getCourseTypeById(Integer courseTypeId);

	// findAll

	public List<CourseType> getAllCourseTypes();
	
	
	

}
