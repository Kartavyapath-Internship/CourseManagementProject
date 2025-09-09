package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseModuleDao;
import com.app.dao.StaffDao;
import com.app.dto.CourseModuleReqDto;
import com.app.dto.CourseModuleRespDto;
import com.app.entity.CourseModule;
import com.app.entity.Staff;

@Service
public class CourseModuleServiceImpl implements CourseModuleService {
	
	@Autowired
    private CourseModuleDao courseModuleDao;
	
	@Autowired
	private ModelMapper modelMapper ;
	
	@Autowired
	private StaffDao staffDao ;

    @Override
    public CourseModuleRespDto addCourseModule(CourseModuleReqDto courseModule) {
    	
    	Staff staff = staffDao.findById(courseModule.getStaffId()).orElseThrow(() -> new RuntimeException("Staff not found by id "+  courseModule.getStaffId()));
    	
    	CourseModule courseM = modelMapper.map(courseModule, CourseModule.class) ;
    	
    	courseM.setStaff(staff);
    	
    	courseM.setId(null);
        
    	CourseModule cModule = courseModuleDao.save(courseM);
        
    	CourseModuleRespDto map = modelMapper.map(cModule, CourseModuleRespDto.class);
    	    	    	
    	return map ;
    }

    @Override
    public CourseModuleRespDto updateCourseModule(Integer id, CourseModuleReqDto updated) {
        
    	CourseModule existing = courseModuleDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Module not found with id " + id));

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setTheoryHours(updated.getTheoryHours());
        existing.setPracticalHours(updated.getPracticalHours());
        
        Staff staff = staffDao.findById(updated.getStaffId()).orElseThrow(() -> new RuntimeException("Staff not found with id "+ updated.getStaffId()));
        
        existing.setStaff(staff);

        CourseModule cModule = courseModuleDao.save(existing);
        
    	CourseModuleRespDto map = modelMapper.map(cModule, CourseModuleRespDto.class);
    	    	    	
    	return map ;
    	
    }

    @Override
    public void deleteCourseModule(Integer id) {
        courseModuleDao.deleteById(id);
    }

    @Override
    public CourseModuleRespDto getCourseModuleById(Integer id) {
    	CourseModule cModule =  courseModuleDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Module not found with id " + id));
    	
    	return modelMapper.map(cModule, CourseModuleRespDto.class); 
    }

    @Override
    public List<CourseModuleRespDto> getAllCourseModules() {
        
    	List<CourseModule> list = courseModuleDao.findAll();
        
        return list.stream().map(cModule -> modelMapper.map(cModule, CourseModuleRespDto.class)).toList();
    }
}
