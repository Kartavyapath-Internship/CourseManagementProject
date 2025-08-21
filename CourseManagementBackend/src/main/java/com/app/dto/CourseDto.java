package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {
	
	 private String name;
	 private String description;
	 private LocalDate startDate;
	 private LocalDate endDate;
	 
	 private String batchCycleTitle;      
	 private String CourseTypeName;
	 private String premisesName;

}
