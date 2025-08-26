package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
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
import lombok.ToString;

@Entity
@Table(name = "course_group")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString // made by vaibhav
public class Group extends BaseEntity {

	@Column(name = "name", nullable = false, length = 50)
	private String groupName;

	@ManyToOne
	@JoinColumn(name = "course_id",nullable = false)
	@JsonIgnoreProperties({ "description", "startDate", "endDate", "batchCycle", "premises", "courseType", "staff" })
	private Course course;

}
