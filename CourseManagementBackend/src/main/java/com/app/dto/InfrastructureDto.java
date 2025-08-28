package com.app.dto;

import com.app.entity.enums.InfrastructureType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class InfrastructureDto {

	private Integer id;

	private String title;

	private String description;

	private String infrastructureType;

	private Integer premisesId;

}
