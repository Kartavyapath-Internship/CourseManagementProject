package com.app.dto;

import java.util.List;

import com.app.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupDto {

	private String groupName;

	private Integer courseId;

<<<<<<< HEAD:CourseManagementBackend/src/main/java/com/app/dto/GroupDto.java
=======
	private String description;
	
	private List<CourseSummaryDto> courses;
	
	
	
>>>>>>> origin/feature/backend-coursetype-api:CourseManagementBackend/src/main/java/com/app/dto/CourseTypeDto.java
}
