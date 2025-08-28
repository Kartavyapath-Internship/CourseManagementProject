package com.app.service;

import java.util.List;

import com.app.dto.CourseDto;
import com.app.dto.CourseRespDto;
import com.app.entity.Course;

public interface CourseService {
	
	public CourseDto addCourse(CourseRespDto dto);
	public CourseDto updateCourse(int id, CourseRespDto dto);
	public void deleteCourse(int id);

	public List<CourseDto> getAllCourses();
	public CourseDto getCourseById(int id);

}
