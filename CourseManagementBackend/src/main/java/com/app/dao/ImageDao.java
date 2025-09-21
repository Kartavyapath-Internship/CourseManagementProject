package com.app.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {

	List<Image> findByCertificateId(int cId);

}
