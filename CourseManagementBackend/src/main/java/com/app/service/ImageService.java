package com.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ImageRespDto;

public interface ImageService {

	String uploadImg(MultipartFile file, int id);

	List<ImageRespDto> getAllByCertiId(int cId);

}
