package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseModuleDao;
import com.app.dao.RecordedVideoDao;
import com.app.dto.RecordedVideoDto;
import com.app.dto.RecordedVideoRespDto;
import com.app.entity.CourseModule;
import com.app.entity.RecordedVideo;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RecordedVideoServiceImpl implements RecordedVideoService {

    private final RecordedVideoDao recordedVideoRepo;
    private final CourseModuleDao courseModuleRepo;


    
//    @Override
//    public RecordedVideoDto addRecordedVideo(RecordedVideoDto dto) {
//        // Fetch CourseModule
//        CourseModule module = courseModuleRepo.findById(dto.getCourseId())
//                .orElseThrow(() -> new RuntimeException("CourseModule not found"));
//
//        // Create entity using no-arg constructor
//        RecordedVideo video = new RecordedVideo();
//        
//        // Set values using reflection-safe approach (cannot use builder/setCourse)
//        video.setVideoTitle(dto.getVideoTitle());
//        video.setVideoUrl(dto.getVideoUrl());
//        video.setDate(dto.getDate());
//
//        // Since setCourseModule() may not exist, we set it via reflection OR via constructor workaround
//        // But if Lombok generated setter exists, do:
//        video.setCourseModule(module);
//
//        recordedVideoRepo.save(video);
//
//        dto.setCourseId(module.getId());
//        return dto;
//    }

    @Override
    public RecordedVideoRespDto addRecordedVideo(RecordedVideoDto dto) {
        CourseModule module = courseModuleRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("CourseModule not found"));

        RecordedVideo video = new RecordedVideo();
        video.setVideoTitle(dto.getVideoTitle());
        video.setVideoUrl(dto.getVideoUrl());
        video.setDate(dto.getDate());
        video.setCourseModule(module);

        RecordedVideo saved = recordedVideoRepo.save(video);

        return mapToRespDto(saved); // 👈 return RespDto
    }

    
//    @Override
//    public RecordedVideoDto updateRecordedVideo(Integer id, RecordedVideoDto dto) {
//        // Fetch existing video
//        RecordedVideo video = recordedVideoRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("RecordedVideo not found"));
//
//        // Fetch the related CourseModule
//        CourseModule module = courseModuleRepo.findById(dto.getCourseId())
//                .orElseThrow(() -> new RuntimeException("CourseModule not found"));
//
//        // Update fields directly
//        try {
//            java.lang.reflect.Field titleField = RecordedVideo.class.getDeclaredField("videoTitle");
//            titleField.setAccessible(true);
//            titleField.set(video, dto.getVideoTitle());
//
//            java.lang.reflect.Field urlField = RecordedVideo.class.getDeclaredField("videoUrl");
//            urlField.setAccessible(true);
//            urlField.set(video, dto.getVideoUrl());
//
//            java.lang.reflect.Field dateField = RecordedVideo.class.getDeclaredField("date");
//            dateField.setAccessible(true);
//            dateField.set(video, dto.getDate());
//
//            java.lang.reflect.Field moduleField = RecordedVideo.class.getDeclaredField("courseModule");
//            moduleField.setAccessible(true);
//            moduleField.set(video, module);
//
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException("Failed to update RecordedVideo fields", e);
//        }
//
//        recordedVideoRepo.save(video);
//        return dto;
//    }
    
    @Override
    public RecordedVideoRespDto updateRecordedVideo(Integer id, RecordedVideoDto dto) {
        RecordedVideo video = recordedVideoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RecordedVideo not found"));

        CourseModule module = courseModuleRepo.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("CourseModule not found"));

        video.setVideoTitle(dto.getVideoTitle());
        video.setVideoUrl(dto.getVideoUrl());
        video.setDate(dto.getDate());
        video.setCourseModule(module);

        RecordedVideo updated = recordedVideoRepo.save(video);

        return mapToRespDto(updated); // 👈 return RespDto
    }

    @Override
    public void deleteRecordedVideo(Integer id) {
        if (!recordedVideoRepo.existsById(id)) {
            throw new RuntimeException("RecordedVideo not found");
        }
        recordedVideoRepo.deleteById(id);
    }
    
    @Override
    public List<RecordedVideoRespDto> getAllRecordedVideos() {
        return recordedVideoRepo.findAll()
                .stream()
                .map(this::mapToRespDto)
                .collect(Collectors.toList());
    }

    private RecordedVideoRespDto mapToRespDto(RecordedVideo video) {
        RecordedVideoRespDto dto = new RecordedVideoRespDto();
        dto.setId(video.getId()); // include ID
        dto.setVideoTitle(video.getVideoTitle());
        dto.setVideoUrl(video.getVideoUrl());
        dto.setDate(video.getDate());
        dto.setCourseId(video.getCourseModule().getId());
        return dto;
    }


//    @Override
//    public RecordedVideoDto getRecordedVideoById(Integer id) {
//        // Fetch the RecordedVideo entity by ID
//        RecordedVideo video = recordedVideoRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("RecordedVideo not found with id: " + id));
//
//        // Map the entity to DTO
//        RecordedVideoDto dto = new RecordedVideoDto();
//        dto.setVideoTitle(video.getVideoTitle());
//        dto.setVideoUrl(video.getVideoUrl());
//        dto.setDate(video.getDate());
//        dto.setCourseId(video.getCourseModule().getId()); // assuming courseModule is not null
//
//        return dto;
//    }

    @Override
    public RecordedVideoRespDto getRecordedVideoById(Integer id) {
        // Fetch the RecordedVideo entity by ID
        RecordedVideo video = recordedVideoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("RecordedVideo not found with id: " + id));

        // Map the entity to RecordedVideoRespDto
        RecordedVideoRespDto respDto = new RecordedVideoRespDto();
        respDto.setId(video.getId());
        respDto.setVideoTitle(video.getVideoTitle());
        respDto.setVideoUrl(video.getVideoUrl());
        respDto.setDate(video.getDate());
        respDto.setCourseId(video.getCourseModule().getId()); // assuming courseModule is not null

        return respDto;
    }


	
}
