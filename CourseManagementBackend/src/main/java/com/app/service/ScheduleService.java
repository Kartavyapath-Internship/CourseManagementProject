package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.dto.ScheduleDto;
import com.app.dto.ScheduleRespDto;
import com.app.entity.Schedule;

public interface ScheduleService {
	
	public Schedule addSchedule(ScheduleDto dto);
	public List<Schedule> getAllSchedules();
	public Schedule getSchedule(int id);
	public Schedule updateSchedule(int id, ScheduleDto dto);
	public void deleteSchedule(int id);
	public List<ScheduleRespDto> getScheduleReport(LocalDate start,LocalDate end);

}
