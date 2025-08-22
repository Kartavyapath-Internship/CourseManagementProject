package com.app.service;

import java.util.List;

import com.app.dto.InfrastructureDto;

public interface InfrastructureService {

	public InfrastructureDto createInfrastructure(InfrastructureDto infrastructureDto);

	public InfrastructureDto updateInfrastructure(InfrastructureDto infrastructureDto, Integer id);

	public InfrastructureDto getInfrastructureById(Integer id);

	public List<InfrastructureDto> getAllInfrastructure();

	public void deleteInfrastructureById(Integer id);

}
