package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseModuleReqDto;
import com.app.dto.CourseModuleRespDto;
import com.app.service.CourseModuleService;

@RestController
@RequestMapping("/api/course-modules")
public class CourseModuleController {
	 
	@Autowired
	private CourseModuleService courseModuleService;

	    @PostMapping
	    public ResponseEntity<CourseModuleRespDto> addCourseModule(@RequestBody CourseModuleReqDto courseModule) {
	        return ResponseEntity.ok(courseModuleService.addCourseModule(courseModule));
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<CourseModuleRespDto> getCourseModule(@PathVariable Integer id) {
	        return ResponseEntity.ok(courseModuleService.getCourseModuleById(id));
	    }

	    @GetMapping
	    public ResponseEntity<List<CourseModuleRespDto>> getAllCourseModules() {
	        return ResponseEntity.ok(courseModuleService.getAllCourseModules());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<CourseModuleRespDto> updateCourseModule(@PathVariable Integer id,
	                                                           @RequestBody CourseModuleReqDto courseModule) {
	        return ResponseEntity.ok(courseModuleService.updateCourseModule(id, courseModule));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteCourseModule(@PathVariable Integer id) {
	        courseModuleService.deleteCourseModule(id);
	        return ResponseEntity.ok("Course Module deleted successfully");
	    }
}
