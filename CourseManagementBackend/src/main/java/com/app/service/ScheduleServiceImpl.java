package com.app.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ScheduleDao;
import com.app.dto.ScheduleRespDto;
import com.app.entity.Schedule;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleDao;

    
    private ScheduleRespDto convertToScheduleRespDto(Schedule s)
    {
    	ScheduleRespDto dto = new ScheduleRespDto();
    	
    	dto.setId(s.getId());
    	dto.setDate(s.getDate());
    	dto.setStartTime(s.getStartTime());
    	dto.setEndTime(s.getEndTime());
    	dto.setModuleName(s.getCourseModule().getTitle());
    	dto.setComment(s.getComment());
    	dto.setInfrastructureName(s.getInfrastructures().stream().map(infra -> infra.getTitle()).toList());
    	dto.setGroupName(s.getGroups().stream().map(group -> group.getGroupName()).toList());
    	dto.setStaffName(s.getStaff().stream().map(staff -> staff.getName()).toList());
    	
    	return dto ;
    }

    public List<ScheduleRespDto> getScheduleReport(LocalDate start, LocalDate end) {
        
    	List<Schedule> schedules = scheduleDao.getScheduleReport(start, end);

        return schedules.stream().map(s -> convertToScheduleRespDto(s)).toList();
    }
    

    
}
