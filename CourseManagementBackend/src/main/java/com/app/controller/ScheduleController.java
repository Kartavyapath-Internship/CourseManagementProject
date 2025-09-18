package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ScheduleReqDto;
import com.app.dto.ScheduleRespDto;
import com.app.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleRespDto> addSchedule(@RequestBody ScheduleReqDto dto) {
        return ResponseEntity.ok(scheduleService.addSchedule(dto));
    }

    @GetMapping
    public ResponseEntity<List<ScheduleRespDto>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }
    
    
   
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleRespDto> getSchedule(@PathVariable int id) {
        return ResponseEntity.ok(scheduleService.getSchedule(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleRespDto> updateSchedule(@PathVariable int id,
                                                   @RequestBody ScheduleReqDto dto) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable int id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("Schedule deleted");
    }
    
    @GetMapping("/report")
    public List<ScheduleRespDto> getScheduleReport(@RequestParam(required = false)
    											   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
    											   @RequestParam(required = false)
    											   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end)
    {
    	return scheduleService.getScheduleReport(start, end);
    }
    
}

