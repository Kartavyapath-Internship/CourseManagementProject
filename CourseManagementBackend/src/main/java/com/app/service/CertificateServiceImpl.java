package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CertificateDao;
import com.app.dto.CertificateReqDto;
import com.app.dto.CertificateRespDto;
import com.app.entity.Certificate;


@Service
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	private CertificateDao dao ;
	
	@Autowired
	private ImageService serv ;
	
	@Override
	public CertificateRespDto getData(String courseName) {
		
		Certificate c = dao.findByCourseName(courseName).orElseThrow(() -> new RuntimeException("Details not found"));
		
		return toRespDto(c);
	}

	@Override
	public String addNewCertificate(CertificateReqDto dto) {
		
		Certificate c = fromReqDto(dto);
		
		dao.save(c);
		
		return "Added Successfully";
	}

	@Override
	public String deleteCertificate(String courseName) {
		
		Certificate c = dao.findByCourseName(courseName).orElseThrow(() -> new RuntimeException("Details not found"));
		
		dao.delete(c);
		
		return "Deleted Successfully";
	}
	
	public CertificateRespDto toRespDto(Certificate c) {
	    CertificateRespDto respDto = new CertificateRespDto();
	    respDto.setId(c.getId()); 
	    respDto.setContent(c.getContent());
	    respDto.setCourseName(c.getCourseName());
	    respDto.setImgs(c.getImages() != null ? serv.getAllByCertiId(c.getId()) : List.of());
	    return respDto;
	}

    public static Certificate fromReqDto(CertificateReqDto reqDto) {
        return Certificate.builder()
                .content(reqDto.getContent())
                .courseName(reqDto.getCourseName())
                .build();
    }

}
