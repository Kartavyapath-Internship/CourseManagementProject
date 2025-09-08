package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ScheduleRespDto;
import com.app.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    
    @GetMapping("/report")
    public List<ScheduleRespDto> getScheduleReport(@RequestParam(required = false)
    											   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
    											   @RequestParam(required = false)
    											   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end)
    {
    	return scheduleService.getScheduleReport(start, end);
    }
    
   
}

