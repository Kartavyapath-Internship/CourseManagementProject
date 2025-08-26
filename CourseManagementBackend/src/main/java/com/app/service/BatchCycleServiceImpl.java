package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.BatchCycleDao;
import com.app.dto.AddBatchCycleDto;
import com.app.entity.BatchCycle;

@Service
@Transactional
public class BatchCycleServiceImpl implements BatchCycleService {

	@Autowired
	BatchCycleDao batchRepo ;

	@Override
	public BatchCycle addBatchCycle(AddBatchCycleDto addBatchCycleDto) {
		
		BatchCycle batch = new BatchCycle(addBatchCycleDto.getName(), addBatchCycleDto.getDescription(), addBatchCycleDto.getStartDate(), addBatchCycleDto.getEndDate(), addBatchCycleDto.getIsActive());
		
		BatchCycle dbBatch = batchRepo.save(batch);
		
		return dbBatch;
	}

	@Override
	public String deleteBatchCycle(int id) {
		
		BatchCycle batch = batchRepo.findById(id).orElseThrow(()-> new RuntimeException("Batch not found"));
		
		batchRepo.delete(batch);
		
		return "deleted successfully";
	}

	@Override
	public BatchCycle editBatchCycle(int id ,AddBatchCycleDto addBatchCycleDto) {
		
		BatchCycle batch = batchRepo.findById(id).orElseThrow(()-> new RuntimeException("Batch not found"));
		
		batch.setName(addBatchCycleDto.getName());
		batch.setDescription(addBatchCycleDto.getDescription());
		batch.setStartDate(addBatchCycleDto.getStartDate());
		batch.setEndDate(addBatchCycleDto.getEndDate());
		batch.setIsActive(addBatchCycleDto.getIsActive());

		BatchCycle dbBatch = batchRepo.save(batch);

		return dbBatch;
	}

	@Override
	public List<BatchCycle> getAllBatchCycle() {
		return batchRepo.findAll();
	}
}
