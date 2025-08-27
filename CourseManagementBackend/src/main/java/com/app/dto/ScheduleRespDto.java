package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.app.entity.enums.InfrastructureType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class ScheduleRespDto {
	
	
	private String type;
	private String infrastructureName;
	private String moduleName;
	private LocalDate date;
//	private LocalDate endDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private String groupName;
	private String staffName;
	private String comment;
	
	public ScheduleRespDto(String type, String infrastructureName, String moduleName, LocalDate date,
			LocalTime startTime, LocalTime endTime, String groupName, String staffName, String comment) {
		this.type = type;
		this.infrastructureName = infrastructureName;
		this.moduleName = moduleName;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.groupName = groupName;
		this.staffName = staffName;
		this.comment = comment;
	}


}
