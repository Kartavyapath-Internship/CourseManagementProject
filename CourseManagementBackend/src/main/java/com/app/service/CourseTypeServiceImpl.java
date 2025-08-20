package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.CourseDao;
import com.app.dao.CourseTypeDao;
import com.app.dto.CourseTypeDto;
import com.app.entity.CourseType;
import com.app.exceptions.ResourseNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseTypeServiceImpl implements CourseTypeService {

	

	@Autowired
	private CourseTypeDao courseTypeRepository;

	@Autowired
	private ModelMapper modelMapper;

	

	@Override
	public CourseType createCourseType(CourseTypeDto courseTypeDto) {

		CourseType courseType = modelMapper.map(courseTypeDto, CourseType.class);

		log.info("Service layer title : {}, description : {}", courseType.getTitle(), courseType.getDescription());

		return courseTypeRepository.save(courseType);

	}

	@Override
	public CourseType updateCourseType(Integer courseTypeId, CourseTypeDto updatedcourseTypeDto) {
		CourseType courseType = courseTypeRepository.findById(courseTypeId).orElseThrow(
				() -> new ResourseNotFoundException("CourseType is not found with given Id: " + courseTypeId));
		courseType.setTitle(updatedcourseTypeDto.getTitle());
		courseType.setDescription(updatedcourseTypeDto.getDescription());
		return courseTypeRepository.save(courseType);

	}

	@Override
	public void deleteCourseType(Integer courseTypeId) {
		// TODO Auto-generated method stub
		CourseType courseType = courseTypeRepository.findById(courseTypeId).orElseThrow(
				() -> new ResourseNotFoundException("CourseType is not found with given Id: " + courseTypeId));

		log.info("In Service  layer coursetype deleted having id {}", courseTypeId);

		courseTypeRepository.delete(courseType);

	}

	@Override
	public CourseType getCourseTypeById(Integer courseTypeId) {
		// TODO Auto-generated method stub

		log.info("In Service  layer coursetype id is {}", courseTypeId);

		Optional<CourseType> courseType = courseTypeRepository.findById(courseTypeId);
		if (courseType.isPresent()) {

			log.info("In Service  layer coursetype id is {}", courseType.get());

			return courseType.get();
		} else {
			throw new ResourseNotFoundException("CourseType is not found with given Id:" + courseTypeId);
		}

	}

	@Override
	public List<CourseType> getAllCourseTypes() {

		log.info("In Service  layer getAllCourseType");

		return courseTypeRepository.findAll();
	}

}
