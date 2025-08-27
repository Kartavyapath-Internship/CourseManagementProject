package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

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

		Course course = courseRepository.findById(sessionDto.getCourseId()).orElseThrow(
				() -> new ResourseNotFoundException("Course is not found with given id: " + sessionDto.getCourseId()));

		Sessions session = modelMapper.map(sessionDto, Sessions.class);

		session.setCourse(course);

		Sessions savedSession = sessionRepository.save(session);

		log.info(" in service layer  session Dto  title is  {}", savedSession.getTitle());

		SessionDto sessionResponseDto = modelMapper.map(savedSession, SessionDto.class);

		sessionResponseDto.setCourseId(course.getId());

		sessionResponseDto.setCourseName(course.getName());

		return sessionResponseDto;

	}

	@Override
	public SessionDto updateSession(SessionDto sessionDto, Integer id) {

		Course course = courseRepository.findById(sessionDto.getCourseId()).orElseThrow(
				() -> new ResourseNotFoundException("Course is not found with given id: " + sessionDto.getCourseId()));

		Sessions session = sessionRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Session is not found with given id: " + id));

		session.setTitle(sessionDto.getTitle());
		session.setCodeShareToken(sessionDto.getCodeShareToken());
		session.setSessionDate(sessionDto.getSessionDate());
		session.setStartTime(sessionDto.getStartTime());
		session.setEndTime(sessionDto.getEndTime());
		session.setZoomMeetingId(sessionDto.getZoomMeetingId());
		session.setZoomMeetingPassword(sessionDto.getZoomMeetingPassword());
		session.setDescription(sessionDto.getDescription());
		session.setCourse(course);

		Sessions savedRepository = sessionRepository.save(session);

		SessionDto responseDto = modelMapper.map(savedRepository, SessionDto.class);

		responseDto.setCourseId(course.getId());
		responseDto.setCourseName(course.getName());

		return responseDto;
	}

	@Override
	public SessionDto getSessionById(Integer id) {

		Sessions session = sessionRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Session is not found with given id: " + id));

		SessionDto sesssionDto = modelMapper.map(session, SessionDto.class);
		sesssionDto.setCourseName(session.getCourse().getName());
		sesssionDto.setCourseId(session.getCourse().getId());
		;

		return sesssionDto;
	}

	@Override
	public List<SessionDto> getAllSession() {
		List<Sessions> sessions = sessionRepository.findAll();
		List<SessionDto> sessionsAllDto = sessions.stream().map(all -> {
			SessionDto dto = modelMapper.map(all, SessionDto.class);
			dto.setCourseId(all.getCourse().getId());
			dto.setCourseName(all.getCourse().getName());
			return dto;
		}).collect(Collectors.toList());

		return sessionsAllDto;
	}

	@Override
	public void deleteSessionById(Integer id) {
		Sessions session = sessionRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Session is not found with given id: " + id));

		sessionRepository.delete(session);
	}

}
