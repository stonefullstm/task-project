package com.taskmanagement.task.controller.dto;

import com.taskmanagement.task.model.Schedule;

public record ScheduleDto(Long id, String title) {
  public static ScheduleDto fromEntity(Schedule schedule) {
    return new ScheduleDto(schedule.getId(), schedule.getTitle());
  }
}
