package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CertificateReqDto;
import com.app.dto.CertificateRespDto;
import com.app.service.CertificateService;

@RestController
@RequestMapping("/certi")
public class CertificateController {

	@Autowired
	private CertificateService serv ;
	
	@GetMapping("/{courseName}")
	public ResponseEntity<CertificateRespDto> getData(@PathVariable String courseName)
	{
		CertificateRespDto resp = serv.getData(courseName) ;
		return ResponseEntity.ok(resp) ;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addNewCertificateDetails(@RequestBody CertificateReqDto dto )
	{
		String msg = serv.addNewCertificate(dto) ;
		return ResponseEntity.ok(msg) ;
	}
	
	@DeleteMapping("/delete/{courseName}")
	public ResponseEntity<String> deleteCertificate(@PathVariable String courseName)
	{
		String msg = serv.deleteCertificate(courseName) ;
		return ResponseEntity.ok(msg) ;
	}

}
