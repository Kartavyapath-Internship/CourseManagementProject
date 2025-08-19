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
@Table(name = "section")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class Section extends BaseEntity {
	
	@Column(name = "section_name",nullable = false,length = 30)
	private String section;
	
	@ManyToOne
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	

}
