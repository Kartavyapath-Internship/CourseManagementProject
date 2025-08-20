package com.app.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRespDto {
	 private String name;
	 private String description;
	 private LocalDate startDate;
	 private LocalDate endDate;
	 private int batchCycleId;      
	 private int courseTypeId;
	 private int premisesId;


}
