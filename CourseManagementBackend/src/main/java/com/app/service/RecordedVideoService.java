package com.app.service;

import java.util.List;
import com.app.dto.RecordedVideoDto;
import com.app.dto.RecordedVideoRespDto;

public interface RecordedVideoService {
    RecordedVideoDto addRecordedVideo(RecordedVideoDto dto);
    RecordedVideoDto updateRecordedVideo(Integer id, RecordedVideoDto dto);
    void deleteRecordedVideo(Integer id);
    RecordedVideoRespDto getRecordedVideoById(Integer id);
    List<RecordedVideoRespDto> getAllRecordedVideos();
}
