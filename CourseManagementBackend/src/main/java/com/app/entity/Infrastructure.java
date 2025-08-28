package com.app.entity;

import com.app.entity.enums.InfrastructureType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "infrastructure")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Infrastructure extends BaseEntity {

	@Column(name = "title", nullable = false, length = 30)
	private String title;

	@Column(name = "description", nullable = false, length = 200)
	private String description;

	@Enumerated(EnumType.STRING)
	private InfrastructureType infrastructureType;

	@ManyToOne()
	@JoinColumn(name = "premise_id", nullable = false)
	private Premises premises;
}
