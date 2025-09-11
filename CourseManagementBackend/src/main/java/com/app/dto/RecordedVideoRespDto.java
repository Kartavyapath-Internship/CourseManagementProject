package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecordedVideoRespDto {
    private Integer id;
    private String videoTitle;
    private String videoUrl;
    private LocalDateTime date;
    private Integer courseId;
}
