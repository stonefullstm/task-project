package com.taskmanagement.task.controller.dto;

import com.taskmanagement.task.model.Schedule;

public record ScheduleCreationDto(String title) {
  public Schedule toEntity() {
    return new Schedule(title);
  }
}
