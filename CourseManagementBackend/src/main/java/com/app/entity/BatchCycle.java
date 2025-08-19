package com.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "batch_cycle")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class BatchCycle extends BaseEntity {
	
	@Column(name = "name",nullable = false,length = 30)
	private String name;
	
	@Column(name = "description",nullable = false,length = 200)
	private String description;
	
	@Column(name = "start_date",nullable = false)
    private LocalDateTime startDate;
	
	@Column(name = "end_date",nullable = false)
	private LocalDateTime endDate;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
}
