package com.app.service;

import com.app.dto.CertificateReqDto;
import com.app.dto.CertificateRespDto;

public interface CertificateService {

	CertificateRespDto getData(String courseName);

	String addNewCertificate(CertificateReqDto dto);

	String deleteCertificate(String courseName);

}
