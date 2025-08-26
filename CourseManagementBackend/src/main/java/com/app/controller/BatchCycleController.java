package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddBatchCycleDto;
import com.app.entity.BatchCycle;
import com.app.service.BatchCycleService;

@RestController
@RequestMapping("/batchcycle")
public class BatchCycleController {
	
	@Autowired
	BatchCycleService batchCycleServ ;

	@PostMapping("/add")
	public ResponseEntity<?> addBatchCycle(@RequestBody AddBatchCycleDto addBatchCycleDto)
	{
		BatchCycle batch = batchCycleServ.addBatchCycle(addBatchCycleDto);
		return ResponseEntity.ok(batch);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBatchCycle(@PathVariable int id)
	{
		String msg = batchCycleServ.deleteBatchCycle(id);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editBatchCycle(@PathVariable int id ,@RequestBody AddBatchCycleDto addBatchCycleDto)
	{
		BatchCycle batch = batchCycleServ.editBatchCycle(id , addBatchCycleDto);
		return ResponseEntity.ok(batch);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllBatchCycle()
	{
		List<BatchCycle> list = batchCycleServ.getAllBatchCycle();
		
		return ResponseEntity.ok(list);
	}
	
}