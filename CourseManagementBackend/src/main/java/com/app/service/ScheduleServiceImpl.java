package com.app.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseModuleDao;
import com.app.dao.GroupDao;
import com.app.dao.InfrastuctureDao;
import com.app.dao.ScheduleDao;
import com.app.dao.StaffDao;
import com.app.dto.ScheduleDto;
import com.app.dto.ScheduleRespDto;
import com.app.entity.CourseModule;
import com.app.entity.Group;
import com.app.entity.Infrastructure;
import com.app.entity.Schedule;
import com.app.entity.Staff;
import com.app.entity.enums.InfrastructureType;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDao scheduleDao;
	
	@Autowired
	private CourseModuleDao courseModuleDao;
	
	@Autowired
	private InfrastuctureDao infrastructureDao;
	
	@Autowired
	private GroupDao dao;
    
    @Autowired
    private StaffDao staffDao;

	
    public Schedule addSchedule(ScheduleDto dto) {
        Schedule schedule = new Schedule();
        schedule.setDate(dto.getDate());
        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());
        schedule.setType(dto.getType());
        schedule.setComment(dto.getComment());

        CourseModule module = courseModuleDao.findById(dto.getCourseModuleId())
                .orElseThrow(() -> new RuntimeException("Module not found"));
        schedule.setCourseModule(module);

        schedule.setInfrastructures(infrastructureDao.findAllById(dto.getInfrastructureId()));
        schedule.setGroups(dao.findAllById(dto.getGroupIds()));

        Staff staff = staffDao.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        schedule.setStaff(staff);
        

        return scheduleDao.save(schedule);
    }
    
    
    public List<Schedule> getAllSchedules() {
        return scheduleDao.findAll();
    }
    
    
    
    public List<ScheduleRespDto> getScheduleReport(LocalDate start, LocalDate end) {
        List<Schedule> schedules = scheduleDao.getScheduleReport(start, end);

        return schedules.stream()
                .map(s -> {
                    ScheduleRespDto dto = new ScheduleRespDto();


                    dto.setType(s.getType() != null ? s.getType().name() : null);


                    if (s.getInfrastructures() != null && !s.getInfrastructures().isEmpty()) {
                        String infraNames = s.getInfrastructures()
                                             .stream()
                                             .map(Infrastructure::getTitle)
                                             .collect(Collectors.joining(", "));
                        dto.setInfrastructureName(infraNames);
                    }


                    if (s.getCourseModule() != null) {
                        dto.setModuleName(s.getCourseModule().getTitle());
                    }

                    dto.setDate(s.getDate());
                    dto.setStartTime(s.getStartTime());
                    dto.setEndTime(s.getEndTime());

                    // groups (join names if multiple)
                    if (s.getGroups() != null && !s.getGroups().isEmpty()) {
                        String groupNames = s.getGroups()
                                             .stream()
                                             .map(Group::getGroupName)
                                             .collect(Collectors.joining(", "));
                        dto.setGroupName(groupNames);
                    }


                    if (s.getStaff() != null) {
                        dto.setStaffName(s.getStaff().getName());
                    }

                    dto.setComment(s.getComment());

                    return dto;
                })
                .collect(Collectors.toList());

    }
    


    
    
    public Schedule getSchedule(int id) {
        return scheduleDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }
    
    
    
    public Schedule updateSchedule(int id, ScheduleDto dto) {
        Schedule schedule = getSchedule(id);

        schedule.setDate(dto.getDate());
        schedule.setStartTime(dto.getStartTime());
        schedule.setEndTime(dto.getEndTime());
        schedule.setType(dto.getType());
        schedule.setComment(dto.getComment());

        CourseModule module = courseModuleDao.findById(dto.getCourseModuleId())
                .orElseThrow(() -> new RuntimeException("Module not found"));
        schedule.setCourseModule(module);

        schedule.setInfrastructures(infrastructureDao.findAllById(dto.getInfrastructureId()));
        schedule.setGroups(dao.findAllById(dto.getGroupIds()));

        Staff staff = staffDao.findById(dto.getStaffId())
                .orElseThrow(() -> new RuntimeException("Staff not found"));
        schedule.setStaff(staff);

        return scheduleDao.save(schedule);
    }
    
    

    public void deleteSchedule(int id) {
        scheduleDao.deleteById(id);
    }
    
}
