package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BatchCycle;

public interface BatchCycleDao extends JpaRepository<BatchCycle, Long> {

	Optional<BatchCycle> findByName(String name);

	Optional<BatchCycle> findById(Long batchCycleId);
}
