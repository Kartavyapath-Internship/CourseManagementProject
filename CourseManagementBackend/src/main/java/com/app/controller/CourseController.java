package com.app.controller;

import com.app.dto.CourseReqDto;
import com.app.dto.CourseRespDto;
import com.app.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

	@Autowired
	private final CourseService courseService;

	 public CourseController(CourseService courseService) {
	     this.courseService = courseService;
	 }
 
	 @PostMapping
	 public CourseRespDto addCourse(@RequestBody CourseReqDto dto) {
	     return courseService.addCourse(dto);
	 }
	
	 
	 @GetMapping
	 public List<CourseRespDto> getAllCourses() {
	     return courseService.getAllCourses();
	 }
	
	 @GetMapping("/{id}")
	 public CourseRespDto getCourseById(@PathVariable int id) {
	     return courseService.getCourseById(id);
	 }
	
	 @PutMapping("/{id}")
	 public CourseRespDto updateCourse(@PathVariable int id, @RequestBody CourseReqDto dto) {
	     return courseService.updateCourse(id, dto);
	 }
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteCourse(@PathVariable int id) {
	    String msg = courseService.deleteCourse(id);
		return ResponseEntity.ok(msg);
	 }

}
