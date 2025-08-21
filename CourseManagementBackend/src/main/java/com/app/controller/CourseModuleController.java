package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CourseModule;
import com.app.service.CourseModuleService;

@RestController
@RequestMapping("/course-modules")
public class CourseModuleController {
	@Autowired
    private CourseModuleService courseModuleService;

    @PostMapping
    public ResponseEntity<CourseModule> addCourseModule(@RequestBody CourseModule courseModule) {
        CourseModule savedModule = courseModuleService.addCourseModule(courseModule);
        return ResponseEntity.ok(savedModule);
    }
}
