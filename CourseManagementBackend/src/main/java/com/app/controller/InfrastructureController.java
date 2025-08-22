package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.InfrastructureDto;
import com.app.entity.CourseType;
import com.app.responsemessage.ApiResponse;
import com.app.service.InfrastructureService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/infrastructure")
@Slf4j
public class InfrastructureController {

	@Autowired
	private InfrastructureService infrastructureService;

	@PostMapping
	public ResponseEntity<InfrastructureDto> addInfrastructure(@RequestBody InfrastructureDto infrastructureDto) {

		return new ResponseEntity<InfrastructureDto>(infrastructureService.createInfrastructure(infrastructureDto),

				HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<List<InfrastructureDto>> getAllInfrastructure() {

		return new ResponseEntity<List<InfrastructureDto>>(infrastructureService.getAllInfrastructure(), HttpStatus.OK);

	}

	@PutMapping("/{id}")
	public ResponseEntity<InfrastructureDto> updateInfrastructure(@RequestBody InfrastructureDto infrastructureDto,
			@PathVariable Integer id) {
		log.info(" update  Controller layer having {} {} ", infrastructureDto, id);

		return new ResponseEntity<InfrastructureDto>(infrastructureService.updateInfrastructure(infrastructureDto, id),

				HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<InfrastructureDto> getInfrastructureById(@PathVariable Integer id) {

		log.info(" get  Controller layer having {} ", id);

		return new ResponseEntity<InfrastructureDto>(infrastructureService.getInfrastructureById(id), HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteInfrastructureById(@PathVariable Integer id) {

		infrastructureService.deleteInfrastructureById(id);

		ApiResponse apiResponse = ApiResponse.builder().message("Infrastructure deleted with id " + id)
				.status(HttpStatus.OK).build();

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

	}

}
