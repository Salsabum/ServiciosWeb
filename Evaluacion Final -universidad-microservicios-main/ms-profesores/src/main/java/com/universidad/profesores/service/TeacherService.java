package com.universidad.profesores.service;

import com.universidad.profesores.client.CursosFeignClient;
import com.universidad.profesores.dto.CourseDTO;
import com.universidad.profesores.dto.TeacherFullDTO;
import com.universidad.profesores.model.Teacher;
import com.universidad.profesores.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final CursosFeignClient cursosFeignClient;

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findById(Long id) {
        return teacherRepository.findById(id);
    }

    public List<TeacherFullDTO> findAllFull() {
        return teacherRepository.findAll().stream()
                .map(teacher -> {
                    TeacherFullDTO dto = new TeacherFullDTO();
                    dto.setId(teacher.getId());
                    dto.setFirstName(teacher.getFirstName());
                    dto.setLastName(teacher.getLastName());
                    dto.setEmail(teacher.getEmail());
                    dto.setSpecialty(teacher.getSpecialty());
                    try {
                        CourseDTO course = cursosFeignClient.getCourseById(teacher.getCourseId());
                        dto.setCourse(course);
                    } catch (Exception e) {
                        dto.setCourse(null);
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
