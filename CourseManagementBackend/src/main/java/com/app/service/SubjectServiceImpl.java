package com.app.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.SubjectDao;
import com.app.dto.CourseRespDto;
import com.app.dto.SubjectDto;
import com.app.dto.SubjectRespDto;
import com.app.entity.Course;
import com.app.entity.Subject;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	private final SubjectDao subjectDao;
	
	private final CourseDao courseDao;
	
	
	
	public SubjectServiceImpl(SubjectDao subjectDao, CourseDao courseDao) {
		super();
		this.subjectDao = subjectDao;
		this.courseDao = courseDao;
	}

	public List<Subject> getAllSubjects() {
		return subjectDao.findAll();
	}
	
	public Subject getSubjectById(int id)
	{
		return subjectDao.findById(id).orElseThrow(() -> new RuntimeException("Subject not found with id " +id));
	}
	
	public SubjectDto addSubject(SubjectRespDto dto) {
		Subject subject = new Subject();
		subject.setName(dto.getName());
		
		Course course = courseDao.findById(dto.getCourseId())
				.orElseThrow(() -> new RuntimeException("Course not found with id" + dto.getCourseId()));
		subject.setCourse(course);
		Subject saved = subjectDao.save(subject);
		
        return new SubjectDto(
        		saved.getId(),
        		saved.getName(),
        		saved.getCourse().getId(),
        		saved.getCourse().getName()
        	);
    }
	
	
	public SubjectDto updateSubject(int id,SubjectRespDto dto) {
		Subject subject = subjectDao.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
		subject.setName(dto.getName());
		
		Course course = courseDao.findById(dto.getCourseId())
				.orElseThrow(() -> new RuntimeException("Course not found with id " + dto.getCourseId()));
		subject.setCourse(course);
        
        Subject updated = subjectDao.save(subject);

        return new SubjectDto(
                updated.getId(),
                updated.getName(),
                updated.getCourse().getId(),
                updated.getCourse().getName()
        );
		
	}
	
	public void deleteSubject(int id) {
		 subjectDao.deleteById(id);
	    }

}
