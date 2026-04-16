package com.universidad.profesores.dto;

import lombok.Data;

@Data
public class TeacherFullDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String specialty;
    private CourseDTO course;
}
