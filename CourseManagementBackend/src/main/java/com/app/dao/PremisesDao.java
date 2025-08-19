package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Premises;

public interface PremisesDao extends JpaRepository<Premises, Integer> {
	
	Optional<Premises> findByInstituteName(String name);
}
