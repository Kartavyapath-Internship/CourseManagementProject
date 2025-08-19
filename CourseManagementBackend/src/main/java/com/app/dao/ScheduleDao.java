package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Schedule;

public interface ScheduleDao extends JpaRepository<Schedule, Integer> {

}
