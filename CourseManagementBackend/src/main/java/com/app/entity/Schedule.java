package com.app.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.app.entity.enums.InfrastructureType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "schedule")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Schedule extends BaseEntity {
	
	@Column(name = "date",nullable = false)
	private LocalDate date;
	
	@Column(name = "start_time",nullable = false)
	private LocalTime startTime;
	
	@Column(name = "date_time",nullable = false)
	private LocalTime endTime;
	
//	@Column(name = "course_type",nullable = false)
//	private String Course;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private InfrastructureType type;
	
	@OneToOne
	@JoinColumn(name="module")
	@JsonIgnore
	private CourseModule courseModule;
	
	@ManyToMany
	@JoinTable(
	    name = "schedule_infrastructure",
	    joinColumns = @JoinColumn(name = "schedule_id"),
	    inverseJoinColumns = @JoinColumn(name = "infra_id")
	)
	@JsonIgnore
	private List<Infrastructure> infrastructures;
	
	@ManyToMany
    @JoinTable(
        name = "schedule_group",
        joinColumns = @JoinColumn(name = "schedule_id"),
        inverseJoinColumns = @JoinColumn(name = "group_id")
    )
	@JsonIgnore
    private List<Group> groups;
	
	@ManyToOne
	@JoinColumn(name = "staff_id")
	@JsonIgnore
	private Staff staff;
	
	private String comment;

}