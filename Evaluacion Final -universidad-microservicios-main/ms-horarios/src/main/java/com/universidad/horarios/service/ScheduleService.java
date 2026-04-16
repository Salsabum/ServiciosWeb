package com.universidad.horarios.service;

import com.universidad.horarios.client.ProfesoresFeignClient;
import com.universidad.horarios.dto.ScheduleFullDTO;
import com.universidad.horarios.dto.TeacherDTO;
import com.universidad.horarios.model.Schedule;
import com.universidad.horarios.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ProfesoresFeignClient profesoresFeignClient;

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    public List<ScheduleFullDTO> findAllFull() {
        return scheduleRepository.findAll().stream()
                .map(schedule -> {
                    ScheduleFullDTO dto = new ScheduleFullDTO();
                    dto.setId(schedule.getId());
                    dto.setDayOfWeek(schedule.getDayOfWeek());
                    dto.setStartTime(schedule.getStartTime());
                    dto.setEndTime(schedule.getEndTime());
                    dto.setClassroom(schedule.getClassroom());
                    try {
                        TeacherDTO teacher = profesoresFeignClient.getTeacherById(schedule.getTeacherId());
                        dto.setTeacher(teacher);
                    } catch (Exception e) {
                        dto.setTeacher(null);
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
