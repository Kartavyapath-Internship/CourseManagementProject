package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
<<<<<<<< HEAD:CourseManagementBackend/src/main/java/com/app/dto/CourseTypeReqDto.java
public class CourseTypeReqDto {
========
@AllArgsConstructor
public class InfrastructureReqDto {
>>>>>>>> BE-Feature-Infrastructure:CourseManagementBackend/src/main/java/com/app/dto/InfrastructureReqDto.java

	private String title;

	private String description;
<<<<<<<< HEAD:CourseManagementBackend/src/main/java/com/app/dto/CourseTypeReqDto.java
	
}
========

	private String infrastructureType;

	private Integer premisesId;

}
>>>>>>>> BE-Feature-Infrastructure:CourseManagementBackend/src/main/java/com/app/dto/InfrastructureReqDto.java
