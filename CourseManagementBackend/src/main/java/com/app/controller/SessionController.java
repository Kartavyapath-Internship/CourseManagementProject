package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SessionDto;
import com.app.responsemessage.ApiResponse;
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

		log.info(" in controller layer course id  {} and session request body  id {}", sessionDto.getCourseId(),
				sessionDto);

		return new ResponseEntity<SessionDto>(sessionService.createSession(sessionDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SessionDto> updateSession(@RequestBody SessionDto sessionDto, @PathVariable Integer id) {

//		log.info(" in controller layer course id  {} and session request body  id {}", sessionDto.getCourseId(),
//				sessionDto);

		return ResponseEntity.ok(sessionService.updateSession(sessionDto, id));
	}

	@GetMapping
	public ResponseEntity<List<SessionDto>> getAllSession() {

//		log.info(" in controller layer course id  {} and session request body  id {}", sessionDto.getCourseId(),
//				sessionDto);

		return new ResponseEntity<List<SessionDto>>(sessionService.getAllSession(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SessionDto> getSessionById(@PathVariable Integer id) {

//		log.info(" in controller layer course id  {} and session request body  id {}", sessionDto.getCourseId(),
//				sessionDto);

		return ResponseEntity.ok(sessionService.getSessionById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteSessionById(@PathVariable Integer id) {

//		log.info(" in controller layer course id  {} and session request body  id {}", sessionDto.getCourseId(),
//				sessionDto);
		ApiResponse apiResponse = ApiResponse.builder().message("Session deleted by id: " + id).status(HttpStatus.OK)
				.build();
		
		sessionService.deleteSessionById(id);

		return ResponseEntity.ok(apiResponse);
	}

}
