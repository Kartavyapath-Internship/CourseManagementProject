package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseModuleDao;
import com.app.dao.SubjectDao;
import com.app.dto.SubjectReqDto;
import com.app.dto.SubjectRespDto;
import com.app.entity.CourseModule;
import com.app.entity.Subject;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao subjectDao;

	@Autowired
	private CourseModuleDao courseModuleDao;

	public List<SubjectRespDto> getAllSubjects() {

		List<Subject> list = subjectDao.findAll();

		return list.stream().map(sub -> convertToSubjectRespDto(sub)).toList();
	}

	public SubjectRespDto getSubjectById(int id) {

		Subject sub = subjectDao.findById(id)
				.orElseThrow(() -> new RuntimeException("Subject not found with id " + id));

		return convertToSubjectRespDto(sub);
	}

	public SubjectRespDto addSubject(SubjectReqDto dto) {

		Subject subject = new Subject();

		subject.setName(dto.getName());

		CourseModule courseM = courseModuleDao.findById(dto.getCourseModuleId())
				.orElseThrow(() -> new RuntimeException("CourseModule not found with id" + dto.getCourseModuleId()));

		subject.setCourseModule(courseM);

		Subject saved = subjectDao.save(subject);

		return convertToSubjectRespDto(saved);
	}

	private SubjectRespDto convertToSubjectRespDto(Subject s) {
		SubjectRespDto dto = new SubjectRespDto();

		dto.setId(s.getId());
		dto.setName(s.getName());
		dto.setCourseModuleName(s.getCourseModule().getTitle());

		return dto;
	}

	public SubjectRespDto updateSubject(int id, SubjectReqDto dto) {

		Subject subject = subjectDao.findById(id)
				.orElseThrow(() -> new RuntimeException("Subject not found by id " + id));

		subject.setName(dto.getName());

		CourseModule courseM = courseModuleDao.findById(dto.getCourseModuleId())
				.orElseThrow(() -> new RuntimeException("CourseModule not found with id" + dto.getCourseModuleId()));

		subject.setCourseModule(courseM);

		Subject updated = subjectDao.save(subject);

		return convertToSubjectRespDto(updated);

	}

	public void deleteSubject(int id) {
		subjectDao.deleteById(id);
	}

}
