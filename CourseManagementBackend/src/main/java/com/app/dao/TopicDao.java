package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Topic;

public interface TopicDao extends JpaRepository<Topic, Integer> {

}
