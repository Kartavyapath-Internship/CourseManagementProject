package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.InfrastuctureDao;
import com.app.dao.PremisesDao;
import com.app.dto.InfrastructureDto;
import com.app.entity.Infrastructure;
import com.app.entity.Premises;
import com.app.entity.enums.InfrastructureType;
import com.app.exceptions.ResourseNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InfrastructureServiceImpl implements InfrastructureService {

	@Autowired
	private InfrastuctureDao infrastuctureRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PremisesDao premisesRepository;

	@Override
	public InfrastructureDto createInfrastructure(InfrastructureDto infrastructureDto) {

		log.info("In service Layer {}", infrastructureDto);

		Premises premises = premisesRepository.findById(infrastructureDto.getPremisesId())
				.orElseThrow(() -> new ResourseNotFoundException(

						"Premises is Not found with given id : " + infrastructureDto.getPremisesId()));

		Infrastructure infrastructure = modelMapper.map(infrastructureDto, Infrastructure.class);

		infrastructure.setPremises(premises);

		Infrastructure savedInfrastructure = infrastuctureRepository.save(infrastructure);

		log.info("In service Layer {}", infrastructure);

		return modelMapper.map(savedInfrastructure, InfrastructureDto.class);
	}

	@Override
	public InfrastructureDto updateInfrastructure(InfrastructureDto infrastructureDto, Integer id) {

		Infrastructure infrastructure = infrastuctureRepository.findById(id)

				.orElseThrow(() -> new ResourseNotFoundException("Infrastructure  is not found with given id: " + id));

		Premises premises = premisesRepository.findById(infrastructureDto.getPremisesId())

				.orElseThrow(() -> new ResourseNotFoundException(

						"Premises is not found with given id: " + infrastructureDto.getPremisesId()));

		infrastructure.setDescription(infrastructureDto.getDescription());
		infrastructure.setInfrastructureType(InfrastructureType.valueOf(infrastructureDto.getInfrastructureType()));
		infrastructure.setTitle(infrastructureDto.getTitle());
		infrastructure.setPremises(premises);

		Infrastructure savedInfrastructure = infrastuctureRepository.save(infrastructure);

		return modelMapper.map(savedInfrastructure, InfrastructureDto.class);

	}

	@Override
	public InfrastructureDto getInfrastructureById(Integer id) {

		Infrastructure infrastructure = infrastuctureRepository.findById(id)

				.orElseThrow(() -> new ResourseNotFoundException("Infrastructure  is not found with given id: " + id));

		log.info(" get  service layer having infrastructure {} with id {} ", infrastructure, id);

		return modelMapper.map(infrastructure, InfrastructureDto.class);
	}

	@Override
	public List<InfrastructureDto> getAllInfrastructure() {

		List<Infrastructure> listInfra = infrastuctureRepository.findAll();

		log.info("get All Infrastructure service layer {}", listInfra);

		return listInfra.stream().map(list -> modelMapper.map(list, InfrastructureDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public void deleteInfrastructureById(Integer id) {

		Infrastructure infrastructure = infrastuctureRepository.findById(id)

				.orElseThrow(() -> new ResourseNotFoundException("Infrastructure  is not found with given id: " + id));

		infrastuctureRepository.delete(infrastructure);

	}

}
