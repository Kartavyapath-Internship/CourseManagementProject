package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SectionReqDto;
import com.app.entity.Section;
import com.app.service.SectionService;

@RestController
@RequestMapping("/section")
public class SectionController {
	
	@Autowired
	SectionService sectionServ ;

	@GetMapping("/{subId}")
	public ResponseEntity<?> getAllSections(@PathVariable int subId)
	{
		List<Section> list = sectionServ.getAllSection(subId) ;
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addNewSection(@RequestBody SectionReqDto srd)
	{
		Section sec =  sectionServ.addNewSection(srd) ; ;
		return ResponseEntity.ok(sec);
	}
	
	@PutMapping("/update/{subId}")
	public ResponseEntity<?> updateSection(@PathVariable int subId , @RequestBody SectionReqDto srd)
	{
		Section sec = sectionServ.updateSection(subId,srd) ;
		return ResponseEntity.ok(sec);
	}
}
