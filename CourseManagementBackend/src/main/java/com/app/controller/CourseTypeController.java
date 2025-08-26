package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CourseTypeDto;
import com.app.entity.CourseType;
import com.app.responsemessage.ApiResponse;
import com.app.service.CourseTypeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/coursetype")
@Slf4j
public class CourseTypeController {

	@Autowired
	private CourseTypeService courseTypeService;

	// create

	@PostMapping
	public ResponseEntity<CourseTypeDto> createCourseType(@RequestBody CourseTypeDto courseTypeDto) {

		log.info("CourseTypeController Layer Description  : {}, Tittle :{}", courseTypeDto.getDescription(),
				courseTypeDto.getTitle());

		return new ResponseEntity<CourseTypeDto>(courseTypeService.createCourseType(courseTypeDto), HttpStatus.CREATED);

	}

	// update

	@PutMapping("/{courseTypeId}")
	public ResponseEntity<CourseTypeDto> updateCourseType(@RequestBody CourseTypeDto courseTypeDto,
			@PathVariable(name = "courseTypeId") Integer courseTypeId) {

		log.info("CourseTypeController Layer {}", courseTypeId);

		return new ResponseEntity<CourseTypeDto>(courseTypeService.updateCourseType(courseTypeId, courseTypeDto),
				HttpStatus.OK);

	}

	// getAll

	@GetMapping()
	public ResponseEntity<List<CourseTypeDto>> getAllCourseType() {

		log.info("CourseTypeController Layer get All CourseType");

		return new ResponseEntity<List<CourseTypeDto>>(courseTypeService.getAllCourseTypes(), HttpStatus.OK);

	}

	// getById

	@GetMapping("/{courseTypeId}")
	public ResponseEntity<CourseTypeDto> getCourseTypeById(@PathVariable(name = "courseTypeId") Integer courseTypeId) {

		log.info("In controller layer coursetype id is {}", courseTypeId);

		return new ResponseEntity<CourseTypeDto>(courseTypeService.getCourseTypeById(courseTypeId), HttpStatus.OK);

	}

	// delete

	@DeleteMapping("/{courseTypeId}")
	public ResponseEntity<ApiResponse> deleteCourseTypeById(@PathVariable(name = "courseTypeId") Integer courseTypeId) {

		courseTypeService.deleteCourseType(courseTypeId);

		log.info("CourseTypeController Layer {}", courseTypeId);

		ApiResponse deleteMeassage = ApiResponse.builder()
				.message("Coursetype deleted Successfully with id :" + courseTypeId).status(HttpStatus.OK).build();

		return new ResponseEntity<ApiResponse>(deleteMeassage, HttpStatus.OK);

	}


}
