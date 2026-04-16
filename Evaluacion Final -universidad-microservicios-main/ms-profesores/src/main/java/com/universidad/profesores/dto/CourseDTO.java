package com.universidad.profesores.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private Long id;
    private String code;
    private String name;
    private Integer credits;
    private String description;
}
