package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.RecordedVideoDao;
import com.app.dto.RecordedVideoDto;
import com.app.entity.Course;
import com.app.entity.RecordedVideo;

@Service
public class RecordedVideoService {
	 @Autowired
	    private RecordedVideoDao recordedVideoDao;

	    @Autowired
	    private CourseDao courseDao;

	    // CREATE
	    public RecordedVideo addRecordedVideo(RecordedVideoDto dto) {
	        Course course = courseDao.findById(dto.getCourseId())
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        RecordedVideo video = RecordedVideo.builder()
	                .videoTitle(dto.getVideoTitle())
	                .videoUrl(dto.getVideoUrl())
	                .date(dto.getDate())
	                .course(course)
	                .build();

	        return recordedVideoDao.save(video);
	    }

	    // READ - All videos
	    public List<RecordedVideo> getAllVideos() {
	        return recordedVideoDao.findAll();
	    }

	    // READ - By ID
	    public RecordedVideo getVideoById(Integer id) {
	        return recordedVideoDao.findById(id)
	                .orElseThrow(() -> new RuntimeException("Video not found with id " + id));
	    }

	    // UPDATE
	    public RecordedVideo updateRecordedVideo(Integer id, RecordedVideoDto dto) {
	        RecordedVideo existing = getVideoById(id);

	        Course course = courseDao.findById(dto.getCourseId())
	                .orElseThrow(() -> new RuntimeException("Course not found"));

	        existing.setVideoTitle(dto.getVideoTitle());
	        existing.setVideoUrl(dto.getVideoUrl());
	        existing.setDate(dto.getDate());
	        existing.setCourse(course);

	        return recordedVideoDao.save(existing);
	    }

	    // DELETE
	    public void deleteRecordedVideo(Integer id) {
	        RecordedVideo video = getVideoById(id);
	        recordedVideoDao.delete(video);
	    }
}
