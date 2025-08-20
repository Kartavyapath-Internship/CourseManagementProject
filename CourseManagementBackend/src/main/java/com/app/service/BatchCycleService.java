package com.app.service;

import java.util.List;

import com.app.dto.AddBatchCycleDto;
import com.app.entity.BatchCycle;

public interface BatchCycleService {

	BatchCycle addBatchCycle(AddBatchCycleDto addBatchCycleDto);

	String deleteBatchCycle(int id);

	BatchCycle editBatchCycle(int id, AddBatchCycleDto addBatchCycleDto);

	List<BatchCycle> getAllBatchCycle();

}
