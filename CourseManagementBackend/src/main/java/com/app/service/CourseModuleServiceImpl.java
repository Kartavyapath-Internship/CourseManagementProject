package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseModuleDao;
import com.app.dto.CourseModuleDto;
import com.app.entity.CourseModule;

@Service
public class CourseModuleServiceImpl implements CourseModuleService {
	@Autowired
    private CourseModuleDao courseModuleDao;

    @Override
    public CourseModule addCourseModule(CourseModule courseModule) {
        return courseModuleDao.save(courseModule);
    }

    @Override
    public CourseModule updateCourseModule(Integer id, CourseModule updated) {
        CourseModule existing = courseModuleDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Module not found with id " + id));

        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setTheoryHours(updated.getTheoryHours());
        existing.setPracticalHours(updated.getPracticalHours());
        existing.setStaff(updated.getStaff());
        existing.setSubject(updated.getSubject());

        return courseModuleDao.save(existing);
    }

    @Override
    public void deleteCourseModule(Integer id) {
        courseModuleDao.deleteById(id);
    }

    @Override
    public CourseModule getCourseModuleById(Integer id) {
        return courseModuleDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Course Module not found with id " + id));
    }

    @Override
    public List<CourseModule> getAllCourseModules() {
        return courseModuleDao.findAll();
    }
}
