package com.app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BatchCycleDao;
import com.app.dao.CourseDao;
import com.app.dao.CourseTypeDao;
import com.app.dao.PremisesDao;
import com.app.dto.CourseReqDto;
import com.app.dto.CourseRespDto;
import com.app.entity.Course;
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

	public List<CourseRespDto> getAllCourses() {
        List<Course> courses = courseDao.findAll();
        List<CourseRespDto> responseList = new ArrayList<>();

        for (Course course : courses) {
        	CourseRespDto dto = convertToDto(course);
            responseList.add(dto);
        }
        return responseList;
    }
	
	public CourseRespDto getCourseById(int id) {
        Course course = courseDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
        return convertToDto(course);
    }
	
	private CourseRespDto convertToDto(Course course) {
	    return new CourseRespDto(
	    		course.getId(),
	            course.getName(),
	            course.getDescription(),
	            course.getStartDate().toLocalDate(),
	            course.getEndDate().toLocalDate(),
	            course.getBatchCycle() != null ? course.getBatchCycle().getName() : null,
	            course.getCourseType() != null ? course.getCourseType().getTitle() : null,
	            course.getPremisesList() != null ? course.getPremisesList().stream().map(Premises::getInstituteName)
	            		.toList(): null
	    );
	}

	
	public CourseRespDto addCourse(CourseReqDto dto) {
        Course course = new Course();
        course.setName(dto.getName());
        course.setDescription(dto.getDescription());
        course.setStartDate(dto.getStartDate().atStartOfDay());
        course.setEndDate(dto.getEndDate().atStartOfDay());
        
        course.setBatchCycle(batchCycleDao.findById(dto.getBatchCycleId())
                        .orElseThrow(() -> new RuntimeException("BatchCycle not found with id: " + dto.getBatchCycleId()))
        );
        
        
        course.setCourseType(courseTypeDao.findById(dto.getCourseTypeId())
                .orElseThrow(() -> new RuntimeException("CourseType not found")));
        
        
        List<Premises> premises = dto.getPremisesId().stream()
        		.map(id -> premisesDao.findById(id).orElseThrow(() -> new RuntimeException("Premises not found")))
        		.toList();
        course.setPremisesList(premises);
        
        Course saved = courseDao.save(course);
        return convertToDto(saved);

    }
	
	
	public CourseRespDto updateCourse(int id, CourseReqDto dto) {
        Course course = courseDao.findById(id).orElseThrow();
        course.setName(dto.getName());
        course.setStartDate(dto.getStartDate().atStartOfDay());
        course.setEndDate(dto.getEndDate().atStartOfDay());
        course.setBatchCycle(batchCycleDao.findById(dto.getBatchCycleId())
                .orElseThrow(() -> new RuntimeException("BatchCycle not found")));

        course.setCourseType(courseTypeDao.findById(dto.getCourseTypeId())
                .orElseThrow(() -> new RuntimeException("CourseType not found")));

        
        List<Premises> premises = dto.getPremisesId().stream()
        		.map(pId -> premisesDao.findById(pId).orElseThrow(() -> new RuntimeException("Premises not found")))
        		.collect(Collectors.toList());
        course.setPremisesList(premises);
                
        Course updated = courseDao.save(course);
        
        return convertToDto(updated);

    }
	
	public String deleteCourse(int id) {
		 courseDao.deleteById(id);
		 return "Deleted succeessfully";
	}

}