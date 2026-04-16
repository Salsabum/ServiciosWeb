package com.universidad.horarios.controller;

import com.universidad.horarios.dto.ScheduleFullDTO;
import com.universidad.horarios.model.Schedule;
import com.universidad.horarios.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules() {
        return scheduleService.findAll();
    }

    @GetMapping("/schedules/full")
    public List<ScheduleFullDTO> getAllSchedulesFull() {
        return scheduleService.findAllFull();
    }
}
