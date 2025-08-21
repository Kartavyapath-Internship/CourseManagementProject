package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseModuleDao;
import com.app.entity.CourseModule;

@Service
public class CourseModuleServiceImpl implements CourseModuleService{
	@Autowired
    private CourseModuleDao courseModuleDao;

    @Override
    public CourseModule addCourseModule(CourseModule courseModule) {
        return courseModuleDao.save(courseModule);
    }
}
