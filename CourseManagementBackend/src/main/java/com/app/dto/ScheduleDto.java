package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.entity.Staff;
import com.app.entity.enums.InfrastructureType;
import com.app.entity.enums.StaffType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
	
	private LocalDate date;
	
	private LocalTime startTime;
	private LocalTime endTime;
	
	private int courseModuleId;
	
	private InfrastructureType type;
	
	private List<Integer> infrastructureId;
	private List<Integer> groupIds;
	
	private int staffId ;
	private String comment;

}
