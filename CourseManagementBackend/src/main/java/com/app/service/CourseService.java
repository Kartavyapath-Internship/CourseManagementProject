package com.app.service;

import java.util.List;

import com.app.dto.CourseReqDto;
import com.app.dto.CourseRespDto;

public interface CourseService {
	
	public CourseRespDto addCourse(CourseReqDto dto);
	
	public CourseRespDto updateCourse(int id, CourseReqDto dto);
	
	public String deleteCourse(int id);

	public List<CourseRespDto> getAllCourses();
	
	public CourseRespDto getCourseById(int id);

}
