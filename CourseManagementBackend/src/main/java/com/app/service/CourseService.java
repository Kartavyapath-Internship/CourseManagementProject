package com.app.service;

import java.util.List;

import com.app.dto.CourseRespDto;
import com.app.entity.Course;

public interface CourseService {
	
	public List<Course> getAllCourses();
	public Course addCourse(CourseRespDto dto);
	public Course updateCourse(int id, CourseRespDto dto);
	public void deleteCourse(int id);

}