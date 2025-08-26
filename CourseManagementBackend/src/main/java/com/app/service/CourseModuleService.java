package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dto.CourseModuleDto;
import com.app.entity.CourseModule;


public interface CourseModuleService {
	 CourseModule addCourseModule(CourseModule courseModule);
	    CourseModule updateCourseModule(Integer id, CourseModule courseModule);
	    void deleteCourseModule(Integer id);
	    CourseModule getCourseModuleById(Integer id);
	    List<CourseModule> getAllCourseModules();
}
