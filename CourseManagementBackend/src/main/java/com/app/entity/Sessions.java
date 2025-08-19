package com.app.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "session")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Sessions extends BaseEntity {
	
	@Column(name = "title",nullable = false,length = 30)
	private String title;
	
	@Column(name = "code_share_token",length = 50)
	private String codeShareToken;
	
	@Column(name = "date_time",nullable = false)
	private LocalDateTime dateAndTime;
	
	@Column(name = "zoom_id",nullable = false,length = 50)
	private String zoomMeetingId;
	
	@Column(name = "zoom_password",nullable = false,length = 30)
	private String zoomMeetingPassword;
	
	
	@OneToMany
	@JoinColumn(name="staff_id")
	private List <Staff> staff;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	
	
	
	
	
	

}
