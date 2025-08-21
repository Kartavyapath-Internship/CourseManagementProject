package com.app.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.app.dao.SubjectDao;
import com.app.dto.SubjectRespDto;
import com.app.entity.Subject;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	private final SubjectDao subjectDao;
	
	public SubjectServiceImpl(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}
	
	public List<Subject> getAllSubjects() {
		return subjectDao.findAll();
	}
	
	public Subject getSubjectById(int id)
	{
		return subjectDao.findById(id).orElseThrow(() -> new RuntimeException("Subject not found with id " +id));
	}
	
	public Subject addSubject(SubjectRespDto dto) {
		Subject subject = new Subject();
		subject.setName(dto.getName());
        return subjectDao.save(subject);
    }
	
	
	public Subject updateSubject(int id,SubjectRespDto dto) {
		Subject subject = subjectDao.findById(id).orElseThrow(() -> new RuntimeException("Subject not found"));
		subject.setName(dto.getName());
		return subjectDao.save(subject);
		
	}
	
	public void deleteSubject(int id) {
		 subjectDao.deleteById(id);
	    }

}
