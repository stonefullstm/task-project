package com.taskmanagement.task.service;

public class ScheduleNotFoundException extends NotFoundException {
  public ScheduleNotFoundException() {
    super("Schedule not found");
  }
}
