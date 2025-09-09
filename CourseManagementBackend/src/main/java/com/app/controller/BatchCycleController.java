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

import com.app.dto.BatchCycleReqDto;
import com.app.dto.BatchCycleRespDto;
import com.app.service.BatchCycleService;

@RestController
@RequestMapping("/batchcycle")
public class BatchCycleController {
	
	@Autowired
	private BatchCycleService batchCycleServ ;

	@PostMapping("/add")
	public ResponseEntity<BatchCycleRespDto> addBatchCycle(@RequestBody BatchCycleReqDto batchCycleDto)
	{
		BatchCycleRespDto batch = batchCycleServ.addBatchCycle(batchCycleDto);
		return ResponseEntity.ok(batch);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBatchCycle(@PathVariable int id)
	{
		String msg = batchCycleServ.deleteBatchCycle(id);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<BatchCycleRespDto> editBatchCycle(@PathVariable int id ,@RequestBody BatchCycleReqDto batchCycleDto)
	{
		BatchCycleRespDto batch = batchCycleServ.editBatchCycle(id , batchCycleDto);
		return ResponseEntity.ok(batch);
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<BatchCycleRespDto>> getAllBatchCycle()
	{
		List<BatchCycleRespDto> list = batchCycleServ.getAllBatchCycle();
		
		return ResponseEntity.ok(list);
	}
	
}