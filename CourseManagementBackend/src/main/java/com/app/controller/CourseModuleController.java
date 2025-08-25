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

import com.app.dto.CourseModuleDto;
import com.app.entity.CourseModule;
import com.app.service.CourseModuleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/course-modules")
public class CourseModuleController {
	 @Autowired
	    private CourseModuleService courseModuleService;

	    // Create
	    @PostMapping
	    public ResponseEntity<CourseModule> addCourseModule(@RequestBody CourseModule courseModule) {
	        return ResponseEntity.ok(courseModuleService.addCourseModule(courseModule));
	    }

	    // Read (get by id)
	    @GetMapping("/{id}")
	    public ResponseEntity<CourseModule> getCourseModule(@PathVariable Integer id) {
	        return ResponseEntity.ok(courseModuleService.getCourseModuleById(id));
	    }

	    // Read all
	    @GetMapping
	    public ResponseEntity<List<CourseModule>> getAllCourseModules() {
	        return ResponseEntity.ok(courseModuleService.getAllCourseModules());
	    }

	    // Update
	    @PutMapping("/{id}")
	    public ResponseEntity<CourseModule> updateCourseModule(@PathVariable Integer id,
	                                                           @RequestBody CourseModule courseModule) {
	        return ResponseEntity.ok(courseModuleService.updateCourseModule(id, courseModule));
	    }

	    // Delete
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteCourseModule(@PathVariable Integer id) {
	        courseModuleService.deleteCourseModule(id);
	        return ResponseEntity.ok("Course Module deleted successfully with id " + id);
	    }
}
