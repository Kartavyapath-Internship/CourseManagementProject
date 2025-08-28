package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RecordedVideoDto;
import com.app.entity.RecordedVideo;
import com.app.service.RecordedVideoService;

@RestController
@RequestMapping("/videos")
public class RecordedVideoController {
	 @Autowired
	    private RecordedVideoService videoService;

	    @PostMapping("/upload")
	    public ResponseEntity<RecordedVideo> uploadVideo(@RequestBody RecordedVideoDto dto) {
	        RecordedVideo video = videoService.addRecordedVideo(dto);
	        return ResponseEntity.ok(video);
}
	    
	    @GetMapping
	    public ResponseEntity<List<RecordedVideo>> getAllVideos() {
	        return ResponseEntity.ok(videoService.getAllVideos());
	    }

	    // READ - Get video by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<RecordedVideo> getVideoById(@PathVariable Integer id) {
	        return ResponseEntity.ok(videoService.getVideoById(id));
	    }

	    // UPDATE - Edit existing video
	    @PutMapping("/{id}")
	    public ResponseEntity<RecordedVideo> updateVideo(@PathVariable Integer id, @RequestBody RecordedVideoDto dto) {
	        return ResponseEntity.ok(videoService.updateRecordedVideo(id, dto));
	    }

	    // DELETE - Remove video
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteVideo(@PathVariable Integer id) {
	        videoService.deleteRecordedVideo(id);
	        return ResponseEntity.ok("Video deleted successfully with id " + id);
	    }
}
