package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SessionDto {
	
	private Integer id;
	
	private String title;

	private String codeShareToken;

	private LocalDate sessionDate;

	private LocalTime startTime;

	private LocalTime endTime;

	private String zoomMeetingId;

	private String zoomMeetingPassword;
	
	private Integer CourseId;

}
