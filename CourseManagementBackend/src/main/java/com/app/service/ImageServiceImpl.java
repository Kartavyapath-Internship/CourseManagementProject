package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.CertificateDao;
import com.app.dao.ImageDao;
import com.app.dto.ImageRespDto;
import com.app.entity.Certificate;
import com.app.entity.Image;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao imgD ;
	
	@Autowired
	private CertificateDao cDao ;
	
	@Override
	public String uploadImg(MultipartFile file, int id) {
		
		Certificate ceerti = cDao.findById(id).orElseThrow(()-> new RuntimeException("Certificate Details not found"));
		
		if(ceerti != null)
		{
			try {
				
				Image i = new Image(file.getBytes(), ceerti);
				imgD.save(i);
				
				return "Upload successsfully";
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return "Upload Failed";
	}

	@Override
	public List<ImageRespDto> getAllByCertiId(int cId) {
		List<Image>list = imgD.findByCertificateId(cId);
		
		List<ImageRespDto> listD = list.stream().map(l -> {
			ImageRespDto d = new ImageRespDto(l.getData());
			return d ;
		}).toList();
		
		return listD;
	}

}
