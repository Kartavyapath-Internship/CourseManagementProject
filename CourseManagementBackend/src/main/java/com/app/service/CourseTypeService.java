package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.dto.CourseTypeDto;
import com.app.entity.CourseType;


public interface CourseTypeService {

	    // create

		public CourseTypeDto createCourseType(CourseTypeDto courseTypeDto);

		// update

		public CourseTypeDto updateCourseType(Integer courseTypeId, CourseTypeDto courseTypeDto);

		// delete

		public void deleteCourseType(Integer courseTypeId);

		// find CourseTypeById

		public CourseTypeDto getCourseTypeById(Integer courseTypeId);

		// findAll

		public List<CourseTypeDto> getAllCourseTypes();
		
	
	
	

}
