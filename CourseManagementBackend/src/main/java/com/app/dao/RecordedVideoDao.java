package com.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.RecordedVideo;

public interface RecordedVideoDao extends JpaRepository<RecordedVideo, Integer> {

}
