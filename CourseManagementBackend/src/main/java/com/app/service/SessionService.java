package com.app.service;

import java.util.List;

import com.app.dto.SessionDto;

public interface SessionService {
	
	//add
	
	public SessionDto createSession(SessionDto sessionDto);
	
	// update 
	
	public SessionDto updateSession(SessionDto sessionDto,Integer id);
	
	// getById
	
	public SessionDto getSessionById(Integer id);
	
	// get All
	
	public List<SessionDto> getAllSession();
	
	
	// delete By Id
	
	public void deleteSessionById(Integer id);
	
	
	
	
	

}
