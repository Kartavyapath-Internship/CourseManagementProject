package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.BatchCycle;
import com.app.entity.CourseType;

@Repository
public interface CourseTypeDao extends JpaRepository<CourseType, Integer> {

}
