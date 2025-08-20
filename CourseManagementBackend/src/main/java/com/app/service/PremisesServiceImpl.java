package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.PremisesDao;
import com.app.dto.PremisesDto;
import com.app.entity.Premises;


@Service
public class PremisesServiceImpl implements PremisesService {

	@Autowired
	PremisesDao premiseRepo ;
	
	@Override
	public Premises addPremise(PremisesDto addPremise) {
		
		Premises premise = new Premises(addPremise.getInstituteName(), addPremise.getAddress(), addPremise.getDescription());
		return premiseRepo.save(premise);
		
		
	}

	@Override
	public String deletePremise(int id) {
		
		Premises premise = premiseRepo.findById(id).orElseThrow(()-> new RuntimeException("premise not found"));
		
		premiseRepo.delete(premise);
		
		return "Premises deleted";
	}
	
	@Override
	public Premises editPremise(PremisesDto addPremise , int id) {
		
		Premises premise = premiseRepo.findById(id).orElseThrow(()-> new RuntimeException("premise not found"));
		
		premise.setInstituteName(addPremise.getInstituteName());
	    premise.setAddress(addPremise.getAddress());
	    premise.setDescription(addPremise.getDescription());
		
		return premiseRepo.save(premise);
		
		
	}

	@Override
	public List<Premises> getAllPremises() {
		return premiseRepo.findAll();
		
	}

}