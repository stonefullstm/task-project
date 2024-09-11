package com.taskmanagement.task.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.task.controller.dto.ScheduleCreationDto;
import com.taskmanagement.task.controller.dto.ScheduleDto;
import com.taskmanagement.task.model.Schedule;
import com.taskmanagement.task.service.ScheduleService;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {
  private final ScheduleService scheduleService;

  public ScheduleController(ScheduleService scheduleService) {
    this.scheduleService = scheduleService;
  }

  @GetMapping
  public List<ScheduleDto> getAllSchedules() {
    List<Schedule> allSchedules = scheduleService.findAll();
    return allSchedules.stream()
        .map(ScheduleDto::fromEntity)
        .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ScheduleDto createSchedule(@RequestBody ScheduleCreationDto scheduleCreationDto) {
    return ScheduleDto.fromEntity(
        scheduleService.create(scheduleCreationDto.toEntity()));
  }

}
