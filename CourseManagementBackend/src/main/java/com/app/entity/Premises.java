package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "premises")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class Premises extends BaseEntity {

	@Column(name = "institute_name", nullable = false, length = 50)
	private String instituteName;

	@Column(name = "address", nullable = false, length = 150, unique = true)
	private String address;

	@Column(name = "description", nullable = false, length = 200)
	private String description;

}
