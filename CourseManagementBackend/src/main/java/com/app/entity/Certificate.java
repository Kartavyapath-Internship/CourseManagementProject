package com.app.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "certificate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Certificate extends BaseEntity {
	
	@Column(name = "content",nullable = false,length = 250)
	private String content;
	
	@Column(name = "course_name",nullable = false,length=30)
	private String course;
	
	@OneToMany
	@JoinColumn(name = "image_id")
	private List<Image> image;
	

}
