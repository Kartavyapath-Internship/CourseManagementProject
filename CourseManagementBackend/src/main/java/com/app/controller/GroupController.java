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
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.GroupReqDto;
import com.app.dto.GroupRespDto;
import com.app.responsemessage.ApiResponse;
import com.app.service.GroupService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/coursegroup")
@Slf4j
public class GroupController {

	@Autowired
	private GroupService courseGroupService;

	// add

	@PostMapping
	public ResponseEntity<GroupRespDto> addCouseGroup(@RequestBody GroupReqDto courseGroupDto) {
		
		log.info("Group name is {} and Course id {} ",courseGroupDto.getGroupName(),courseGroupDto.getCourseId());

		return new ResponseEntity<GroupRespDto>(courseGroupService.addCourseGroup(courseGroupDto), HttpStatus.CREATED);

	}

	// get all

	@GetMapping
	public ResponseEntity<List<GroupRespDto>> getAllCourseGroups() {

		log.info("Fetching all CourseGroups");

		return new ResponseEntity<List<GroupRespDto>>(courseGroupService.getAllCourseGroup(), HttpStatus.OK);
	}

	// Get CourseGroup by ID

	@GetMapping("/{id}")
	public ResponseEntity<GroupRespDto> getCourseGroupById(@PathVariable Integer id) {

		log.info("Fetching CourseGroup by id: {}", id);

		return new ResponseEntity<GroupRespDto>(courseGroupService.getCourseGroupById(id), HttpStatus.OK);
	}

	// Update CourseGroup

	@PutMapping("/{id}")
	public ResponseEntity<GroupRespDto> updateCourseGroup(@RequestBody GroupReqDto courseGroupDto ,@PathVariable Integer id ) {

		log.info("Controller Updating CourseGroup with GroupName {} and id with {}", courseGroupDto.getGroupName(),courseGroupDto.getCourseId());

		return new ResponseEntity<GroupRespDto>(courseGroupService.updateCourseGroup(courseGroupDto, id), HttpStatus.OK);
	}

	// Delete CourseGroup

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteCourseGroup(@PathVariable Integer id) {
		
		log.info("Deleting CourseGroup with id: {}", id);

		courseGroupService.deleteCourseGroup(id);

		ApiResponse apiResponse = ApiResponse.builder().message("Course Group Deleted Successfully with id : " + id)
				.status(HttpStatus.OK).build();

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}
}