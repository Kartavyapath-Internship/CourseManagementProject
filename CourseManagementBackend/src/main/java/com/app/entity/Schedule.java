package com.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	private LocalDateTime date;
	
	@Column(name = "start_time",nullable = false)
	private LocalDateTime startTime;
	
	@Column(name = "date_time",nullable = false)
	private LocalDateTime endTime;
	
	@Column(name = "course_type",nullable = false)
	private String Course;
	
	@OneToOne
	@JoinColumn(name="module")
	private CourseModule courseModule;
	
	@ManyToMany
	@JoinTable(
	    name = "schedule_infrastructure",
	    joinColumns = @JoinColumn(name = "schedule_id"),
	    inverseJoinColumns = @JoinColumn(name = "infra_id")
	)
	private List<Infrastructure> infrastructures;
	
	@ManyToMany
    @JoinTable(
        name = "schedule_group",
        joinColumns = @JoinColumn(name = "schedule_id"),
        inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;	

}
