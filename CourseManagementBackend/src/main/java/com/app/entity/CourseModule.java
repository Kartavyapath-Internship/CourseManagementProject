package com.app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CourseModule extends BaseEntity{
	@Column(name = "title",nullable = false,length = 30)
	private String title;
	
	@Column(name = "description",nullable = false,length = 200)
	private String description;
	
	@Column(name = "theory_hours",nullable = false,length = 20)
	private String theoryHours;
	
	@Column(name = "practical_hours",nullable = false,length = 20)
	private String practicalHours;
	
	@OneToOne
	@JoinColumn(name="module_router")
	@JsonIgnore
	private Staff staff;
	
	@OneToMany
	@JoinColumn(name = "subject_id")
	@JsonIgnore
	private List<Subject> subject;
}
