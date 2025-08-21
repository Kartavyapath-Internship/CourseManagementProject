package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BatchCycleDao;
import com.app.dao.CourseDao;
import com.app.dao.CourseTypeDao;
import com.app.dao.PremisesDao;
import com.app.dto.CourseDto;
import com.app.dto.CourseRespDto;
import com.app.entity.BatchCycle;
import com.app.entity.Course;
import com.app.entity.CourseType;
import com.app.entity.Premises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private final CourseDao courseDao;
	
	@Autowired
    private final BatchCycleDao batchCycleDao;
	
	@Autowired
    private final CourseTypeDao courseTypeDao;
	
	@Autowired
    private final PremisesDao premisesDao;
	
	public CourseServiceImpl(CourseDao courseDao, BatchCycleDao batchCycleDao
    		,CourseTypeDao courseTypeDao,PremisesDao premisesDao) {
        this.courseDao = courseDao;
        this.batchCycleDao = batchCycleDao;
        this.courseTypeDao = courseTypeDao;
        this.premisesDao = premisesDao;
        
    }

	public List<CourseDto> getAllCourses() {
        List<Course> courses = courseDao.findAll();
        List<CourseDto> responseList = new ArrayList<>();

        for (Course course : courses) {
        	CourseDto dto = convertToDto(course);
            responseList.add(dto);
        }
        return responseList;
    }
	
	public CourseDto getCourseById(int id) {
        Course course = courseDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
        return convertToDto(course);
    }
	
	private CourseDto convertToDto(Course course) {
	    return new CourseDto(
	            course.getName(),
	            course.getDescription(),
	            course.getStartDate().toLocalDate(),
	            course.getEndDate().toLocalDate(),
	            course.getBatchCycle() != null ? course.getBatchCycle().getName() : null,
	            course.getCourseType() != null ? course.getCourseType().getTitle() : null,
	            course.getPremises() != null ? course.getPremises().getInstituteName() : null
	    );
	}

	
	public Course addCourse(CourseRespDto dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setStartDate(dto.getStartDate().atStartOfDay());
        course.setEndDate(dto.getEndDate().atStartOfDay());
        
        course.setBatchCycle(
                batchCycleDao.findById(dto.getBatchCycleId())
                        .orElseThrow(() -> new RuntimeException("BatchCycle not found with id: " + dto.getBatchCycleId()))
        );
        
        
        CourseType courseType = courseTypeDao.findById(dto.getCourseTypeId())
                .orElseThrow(() -> new RuntimeException("CourseType not found with id: " + dto.getCourseTypeId()));
        course.setCourseType(courseType); 
        
        
        Premises premises = premisesDao.findById(dto.getPremisesId())
                .orElseThrow(() -> new RuntimeException("Premises not found"));
        course.setPremises(premises);
          
        return courseDao.save(course);
    }
	
	
	public Course updateCourse(int id, CourseRespDto dto) {
        Course course = courseDao.findById(id).orElseThrow();
        course.setName(dto.getName());
        course.setStartDate(dto.getStartDate().atStartOfDay());
        course.setEndDate(dto.getEndDate().atStartOfDay());
        course.setBatchCycle(batchCycleDao.findById(dto.getBatchCycleId())
                .orElseThrow(() -> new RuntimeException("BatchCycle not found")));

        course.setCourseType(courseTypeDao.findById(dto.getCourseTypeId())
                .orElseThrow(() -> new RuntimeException("CourseType not found")));

        
        Premises premises = premisesDao.findById(dto.getPremisesId())
                .orElseThrow(() -> new RuntimeException("Premises not found"));
        course.setPremises(premises);
        
        return courseDao.save(course);
    }
	
	
	public void deleteCourse(int id) {
		 courseDao.deleteById(id);;
	    }

}
