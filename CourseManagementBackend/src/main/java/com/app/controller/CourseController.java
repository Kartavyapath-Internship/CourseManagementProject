package com.app.controller;

import com.app.dto.CourseReqDto;
import com.app.dto.CourseRespDto;
import com.app.responsemessage.ApiResponse;
import com.app.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
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

	// ✅ Assign coordinator
	@PutMapping("/{courseId}/assign-coordinator/{staffId}")
	public ResponseEntity<CourseRespDto> assignCoordinator(@PathVariable int courseId, @PathVariable int staffId) {
		return ResponseEntity.ok(courseService.assignCoordinator(courseId, staffId));
	}

	// ✅ Remove coordinator
	@PutMapping("/{courseId}/remove-coordinator")
	public ResponseEntity<ApiResponse> removeCoordinator(@PathVariable int courseId) {

		ApiResponse removeMessage = ApiResponse.builder()
				.message("Coordinator removed  Successfully with courseId :" + courseId).status(HttpStatus.OK)
				.statusCode(200).timestamp(LocalDateTime.now()).build();

		courseService.removeCoordinator(courseId);

		return ResponseEntity.ok(removeMessage);
	}
}
