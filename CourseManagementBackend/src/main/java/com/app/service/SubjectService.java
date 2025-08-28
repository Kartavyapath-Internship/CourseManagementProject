package com.app.service;

import java.util.List;

import com.app.dto.SubjectDto;
import com.app.dto.SubjectRespDto;
import com.app.entity.Subject;

public interface SubjectService {
	
	public List<Subject> getAllSubjects();
	public SubjectDto addSubject(SubjectRespDto dto);
	public SubjectDto updateSubject(int id,SubjectRespDto dto);
	public void deleteSubject(int id);
	public Subject getSubjectById(int id);

}
