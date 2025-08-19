package com.app.controller;

import com.app.dto.CourseRespDto;
import com.app.entity.*;
import com.app.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
 public Course addCourse(@RequestBody CourseRespDto dto) {
     return courseService.addCourse(dto);
 }

 @GetMapping
 public List<Course> getAllCourses() {
     return courseService.getAllCourses();
 }

// @GetMapping("/{id}")
// public Course getCourseById(@PathVariable Long id) {
//     return courseService.getCourseById(id);
// }

 @PutMapping("/{id}")
 public Course updateCourse(@PathVariable Long id, @RequestBody CourseRespDto dto) {
     return courseService.updateCourse(id, dto);
 }

 @DeleteMapping("/{id}")
 public void deleteCourse(@PathVariable Long id) {
     courseService.deleteCourse(id);
 }
 

}
