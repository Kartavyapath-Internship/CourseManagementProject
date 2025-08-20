package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.BatchCycle;
import com.app.entity.CourseType;

public interface CourseTypeDao extends JpaRepository<CourseType, Long> {


}
