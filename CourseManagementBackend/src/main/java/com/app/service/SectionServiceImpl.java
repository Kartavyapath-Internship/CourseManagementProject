package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SectionDao;
import com.app.dao.SubjectDao;
import com.app.dto.SectionReqDto;
import com.app.entity.Section;
import com.app.entity.Subject;

@Service
@Transactional
public class SectionServiceImpl implements SectionService {
	
	@Autowired
	SectionDao sectionDao ;

	@Autowired
	SubjectDao subjectDao ;

	@Override
	public List<Section> getAllSection(int subId) {
		// TODO Auto-generated method stub
		return sectionDao.findAllBySubjectId(subId);
	}

	@Override
	public Section addNewSection(SectionReqDto srd) {
		// TODO Auto-generated method stub
		Subject subject = subjectDao.findById(srd.getSubjectId()).orElseThrow(()-> new RuntimeException("Subject not found"));
		
		Section section = new Section(srd.getSection(), subject);

		return sectionDao.save(section);
	}

	@Override
	public Section updateSection(int subId, SectionReqDto srd) {
		// TODO Auto-generated method stub
		
		Section section = sectionDao.findById(subId).orElseThrow(()-> new RuntimeException("section not found"));
		
		section.setSection(srd.getSection());
		
		if(!section.getSubject().getId().equals(srd.getSubjectId()))
		{
			Subject subject = subjectDao.findById(srd.getSubjectId()).orElseThrow(()-> new RuntimeException("Subject not found"));
			section.setSubject(subject);
		}
		
		return sectionDao.save(section);

	}

	@Override
	public String deleteSection(int secId) {
		Section section = sectionDao.findById(secId).orElseThrow(()-> new RuntimeException("section not found"));
		
		sectionDao.delete(section);
		
		return "Deleted Successfully";
	}

}
