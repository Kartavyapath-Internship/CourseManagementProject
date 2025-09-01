package com.app.dao;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BatchCycle;
import com.app.entity.Premises;

public interface PremisesDao extends JpaRepository<Premises, Integer> {

	List<Premises> findAllById(int premisesId);
	

}
