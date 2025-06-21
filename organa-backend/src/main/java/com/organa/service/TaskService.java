package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateTaskDTO;
import com.organa.dto.request.update.UpdateTaskDTO;
import com.organa.dto.response.TaskResponseDTO;

public interface TaskService {

  TaskResponseDTO createTask(CreateTaskDTO dto);

  TaskResponseDTO getTaskById(Long id);

  List<TaskResponseDTO> getAllTasks();

  TaskResponseDTO updateTask(Long id, UpdateTaskDTO dto);

  void deleteTask(Long id);
}
