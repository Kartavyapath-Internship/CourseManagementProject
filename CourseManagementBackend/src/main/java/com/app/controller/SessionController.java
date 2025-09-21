package com.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SessionReqDto;
import com.app.dto.SessionRespDto;
import com.app.responsemessage.ApiResponse;
import com.app.service.SessionService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/session")
@Slf4j
@CrossOrigin("*")
public class SessionController {

	@Autowired
	private SessionService sessionService;

	@PostMapping
	public ResponseEntity<SessionRespDto> createSession(@RequestBody SessionReqDto sessionDto) {

		log.info(" in controller layer course id  {} and session request body  id {}", sessionDto.getCourseModuleId(),
				sessionDto);

		return new ResponseEntity<SessionRespDto>(sessionService.createSession(sessionDto), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<SessionRespDto> updateSession(@RequestBody SessionReqDto sessionDto,
			@PathVariable Integer id) {

		return ResponseEntity.ok(sessionService.updateSession(sessionDto, id));
	}

	@GetMapping
	public ResponseEntity<List<SessionRespDto>> getAllSession() {

		return new ResponseEntity<List<SessionRespDto>>(sessionService.getAllSession(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SessionRespDto> getSessionById(@PathVariable Integer id) {

		return ResponseEntity.ok(sessionService.getSessionById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteSessionById(@PathVariable Integer id) {

		ApiResponse apiResponse = ApiResponse.builder().message("Session deleted by id: " + id).status(HttpStatus.OK)
				.statusCode(200).timestamp(LocalDateTime.now()).build();

		sessionService.deleteSessionById(id);

		return ResponseEntity.ok(apiResponse);
	}

	@GetMapping("/filter")
	public ResponseEntity<List<SessionRespDto>> getSessionsWithFilters(@RequestParam(required = false) LocalDate date,
			@RequestParam(required = false) Integer moduleId, @RequestParam(required = false) Boolean active) {

		log.info("inside date {} inside  muduleId {} inside active {} ", date, moduleId, active);

		return ResponseEntity.ok(sessionService.getSessionsWithFilters(date, moduleId, active));
	}

}
