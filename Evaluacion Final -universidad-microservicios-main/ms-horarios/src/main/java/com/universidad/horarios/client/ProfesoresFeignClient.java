package com.universidad.horarios.client;

import com.universidad.horarios.dto.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-profesores", url = "http://localhost:8082", configuration = FeignConfig.class)
public interface ProfesoresFeignClient {

    @GetMapping("/api/teachers/{id}")
    TeacherDTO getTeacherById(@PathVariable("id") Long id);
}
