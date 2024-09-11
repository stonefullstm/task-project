package com.taskmanagement.task.service;

import org.springframework.stereotype.Service;

import com.taskmanagement.task.model.Schedule;
import com.taskmanagement.task.repository.ScheduleRepository;
import java.util.List;

@Service
public class ScheduleService {
  private final ScheduleRepository scheduleRepository;

  public ScheduleService(ScheduleRepository scheduleRepository) {
    this.scheduleRepository = scheduleRepository;
  }

  public Schedule findById(Long id) throws ScheduleNotFoundException {
    return scheduleRepository.findById(id).orElseThrow(ScheduleNotFoundException::new);
  }

  public List<Schedule> findAll() {
    return scheduleRepository.findAll();
  }

  public Schedule create(Schedule schedule) {
    return scheduleRepository.save(schedule);
  }
}
