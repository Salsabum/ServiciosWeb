package com.universidad.horarios.dto;

import lombok.Data;

@Data
public class ScheduleFullDTO {
    private Long id;
    private String dayOfWeek;
    private String startTime;
    private String endTime;
    private String classroom;
    private TeacherDTO teacher;
}
