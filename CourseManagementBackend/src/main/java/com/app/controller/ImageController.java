package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ImageRespDto;
import com.app.service.ImageService;

@RestController
@RequestMapping("/img")
public class ImageController {
	
	@Autowired
	private ImageService imgServ ;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("id") int id)
	{
		String msg = imgServ.uploadImg(file, id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/get/{cId}")
	public ResponseEntity<List<ImageRespDto>> getByCertiId(@PathVariable int cId)
	{
		return ResponseEntity.ok(imgServ.getAllByCertiId(cId)) ;
	}
}
