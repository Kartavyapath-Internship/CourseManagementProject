package com.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.RecordedVideoDto;
import com.app.dto.RecordedVideoRespDto;
import com.app.service.RecordedVideoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recorded-videos")
@RequiredArgsConstructor
public class RecordedVideoController {

    private final RecordedVideoService recordedVideoService;

    @PostMapping
    public ResponseEntity<RecordedVideoDto> addRecordedVideo(@RequestBody RecordedVideoDto dto) {
        return ResponseEntity.ok(recordedVideoService.addRecordedVideo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecordedVideoDto> updateRecordedVideo(
            @PathVariable Integer id,
            @RequestBody RecordedVideoDto dto) {
        return ResponseEntity.ok(recordedVideoService.updateRecordedVideo(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecordedVideo(@PathVariable Integer id) {
        recordedVideoService.deleteRecordedVideo(id);
        return ResponseEntity.ok("Recorded video deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordedVideoRespDto> getRecordedVideoById(@PathVariable Integer id) {
        return ResponseEntity.ok(recordedVideoService.getRecordedVideoById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecordedVideoRespDto>> getAllRecordedVideos() {
        return ResponseEntity.ok(recordedVideoService.getAllRecordedVideos());
    }
}
