package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.GroupDao;
import com.app.dto.GroupDto;
import com.app.entity.Course;
import com.app.entity.Group;
import com.app.exceptions.ResourseNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao courseGroupRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CourseDao courseRepository;

	@Override
	public Group addCourseGroup(GroupDto courseGroupDto) {

		Course course = courseRepository.findById(courseGroupDto.getCourseId()).orElseThrow(() ->

		new ResourseNotFoundException(

				"Course is not present in database with given Id:" + courseGroupDto.getCourseId()));

		Group courseGroup = modelMapper.map(courseGroupDto, Group.class);

		courseGroup.setCourse(course);

//		log.info("Service Layer Course GroupName {} GroupdId {} CourseName {} ", courseGroup.getGroupName(),
//				courseGroup.getId(), courseGroup.getCourse().getName());

		 Group save = courseGroupRepository.save(courseGroup);
		
		 log.info("Service Layer  Course GroupName {} groupId {} courseName {}", save.getGroupName(),save.getId(),save.getCourse().getName());
		 
		 return save;

	}

	@Override
	public Group updateCourseGroup(GroupDto courseGroupDto, Integer id) {

		Group courseGroup = courseGroupRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Course group is not found with given id : " + id));

		courseGroup.setGroupName(courseGroupDto.getGroupName());

		if (courseGroupDto.getCourseId() != null) {

			Course course = courseRepository.findById(courseGroupDto.getCourseId())

					.orElseThrow(() -> new ResourseNotFoundException(

							"Course is not present in database with given Id:" + courseGroupDto.getCourseId()));

			courseGroup.setCourse(course);
		}

		log.info("Service Layer update Course GroupName {} groupId {} courseName {}", courseGroup.getGroupName(),courseGroup.getId(),courseGroup.getCourse().getName());

		return courseGroupRepository.save(courseGroup);

	}

	@Override
	public void deleteCourseGroup(Integer id) {

		Group courseGroup = courseGroupRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Course group is not found with given id : " + id));

		log.info("Service Layer delete Course Group with id {} ", id);

		courseGroupRepository.delete(courseGroup);
	}

	@Override
	public Group getCourseGroupById(Integer id) {

		Group courseGroup = courseGroupRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Course group is not found with given id : " + id));

		log.info("Service Layer getCourseGroup with id {} ", id);

		return courseGroup;
	}

	@Override
	public List<Group> getAllCourseGroup() {

		return courseGroupRepository.findAll();

	}

}
