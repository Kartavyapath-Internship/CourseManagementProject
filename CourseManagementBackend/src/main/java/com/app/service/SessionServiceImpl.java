package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.SessionsDao;
import com.app.dto.SessionDto;
import com.app.entity.Course;
import com.app.entity.Sessions;
import com.app.exceptions.ResourseNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SessionServiceImpl implements SessionService {

	@Autowired
	private CourseDao courseRepository;
	
	@Autowired
	private SessionsDao sessionRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public SessionDto createSession(SessionDto sessionDto) {
		
		Course course = courseRepository.findById(sessionDto.getCourseId()).orElseThrow(()->
										new ResourseNotFoundException("Course is not found with given id"+sessionDto.getCourseId()));
		Sessions session = modelMapper.map(sessionDto, Sessions.class);
		session.setId(null);
		session.setCourse(course);
		
		Sessions savedSession = sessionRepository.save(session);
		
		log.info(" in service layer  session Dto  {}",savedSession);
		return modelMapper.map(savedSession, SessionDto.class);
	}

	@Override
	public SessionDto updateSession(SessionDto sessionDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionDto getSessionById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionDto getAllSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionDto deleteSessionById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
