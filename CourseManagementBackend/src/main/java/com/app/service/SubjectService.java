package com.app.service;

import java.util.List;

import com.app.dto.SubjectRespDto;
import com.app.entity.Subject;

public interface SubjectService {
	
	public List<Subject> getAllSubjects();
	public Subject addSubject(SubjectRespDto dto);
	public Subject updateSubject(Long id,SubjectRespDto dto);
	public void deleteSubject(Long id);
	public Subject getSubjectById(Long id);

}
