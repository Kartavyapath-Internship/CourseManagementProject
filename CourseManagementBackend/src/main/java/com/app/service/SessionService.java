package com.app.service;

import com.app.dto.SessionDto;

public interface SessionService {
	
	//add
	
	public SessionDto createSession(SessionDto sessionDto);
	
	// update 
	
	public SessionDto updateSession(SessionDto sessionDto,Integer id);
	
	// getById
	
	public SessionDto getSessionById(Integer id);
	
	// get All
	
	public SessionDto getAllSession();
	
	
	// delete By Id
	
	public SessionDto deleteSessionById(Integer id);
	
	
	
	
	

}
