package com.app.service;

import java.util.List;

import com.app.dto.GroupDto;
import com.app.entity.Group;

public interface GroupService {

	//add
	
	public Group addCourseGroup(GroupDto courseGroupDto);
	
	// update
	
	public Group updateCourseGroup(GroupDto courseGroupDto,Integer id);
	
	// delete
	
	public void deleteCourseGroup(Integer id);
	
	// get by id
	
	public Group getCourseGroupById(Integer id);
	
	// get all Course group
	
	public List<Group> getAllCourseGroup();
}
