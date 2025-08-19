package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course_group")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Group extends BaseEntity {
	
	@Column(name = "name",nullable = false ,length=30)
	private String groupName;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

}
