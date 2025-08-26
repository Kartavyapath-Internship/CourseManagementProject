package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SessionDto;
import com.app.service.SessionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/session")
@Slf4j
public class SessionController {

	@Autowired
	private SessionService sessionService;

	@PostMapping
	public ResponseEntity<SessionDto> createSession(@RequestBody SessionDto sessionDto) {
		
		log.info(" in controller layer course id  {} and get session id {}",sessionDto.getCourseId(),sessionDto.getId());

		return new ResponseEntity<SessionDto>(sessionService.createSession(sessionDto), HttpStatus.CREATED);
	}

}
