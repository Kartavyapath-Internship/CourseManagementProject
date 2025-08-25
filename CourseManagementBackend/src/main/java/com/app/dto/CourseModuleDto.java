package com.app.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.app.entity.CourseModule;

public class CourseModuleDto {
	 private Integer id;
	    private String title;
	    private String description;
	    private String theoryHours;
	    private String practicalHours;
	    private String staffName;
	    private List<String> subjects;

	    public CourseModuleDto(CourseModule cm) {
	        this.id = cm.getId();
	        this.title = cm.getTitle();
	        this.description = cm.getDescription();
	        this.theoryHours = cm.getTheoryHours();
	        this.practicalHours = cm.getPracticalHours();
	        this.staffName = (cm.getStaff() != null) ? cm.getStaff().getName() : null;
	        this.subjects = cm.getSubject() != null ?
	                cm.getSubject().stream().map(s -> s.getName()).collect(Collectors.toList())
	                : null;
	    }
}
