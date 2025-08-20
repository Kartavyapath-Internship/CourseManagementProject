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
	 private Long id;
	 private String name;
	 private String description;
	 private LocalDate startDate;
	 private LocalDate endDate;
	 private Long batchCycleId;      
	 private Long courseTypeId;
	 private Long premisesId;
	
 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public Long getBatchCycleId() {
		return batchCycleId;
	}
	public void setBatchCycleId(Long batchCycleId) {
		this.batchCycleId = batchCycleId;
	}
	public Long getCourseTypeId() {
		return courseTypeId;
	}
	public Long getPremisesId() {
		return premisesId;
	}
	public void setPremisesId(Long premisesId) {
		this.premisesId = premisesId;
	}
	public void setCourseTypeId(Long courseTypeId) {
		this.courseTypeId = courseTypeId;
	}



}
