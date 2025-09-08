package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ScheduleRespDto;

public interface ScheduleService {
	
	public List<ScheduleRespDto> getScheduleReport(LocalDate start,LocalDate end);

}
