package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateTaskDTO;
import com.organa.dto.request.update.UpdateTaskDTO;
import com.organa.dto.response.TaskResponseDTO;
import com.organa.entity.Project;
import com.organa.entity.Task;
import com.organa.entity.User;
import com.organa.mapper.TaskMapper;
import com.organa.repository.ProjectRepository;
import com.organa.repository.TaskRepository;
import com.organa.repository.UserRepository;
import com.organa.service.TaskService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskServiceImpl implements TaskService {
  private final TaskRepository taskRepository;
  private final UserRepository userRepository;
  private final ProjectRepository projectRepository;
  private final TaskMapper taskMapper;

  public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository,
      ProjectRepository projectRepository, TaskMapper taskMapper) {
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
    this.projectRepository = projectRepository;
    this.taskMapper = taskMapper;
  }

  @Override
  public TaskResponseDTO createTask(CreateTaskDTO dto) {
    User assignee = userRepository.findById(dto.assigneeId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    Project project = projectRepository.findById(dto.projectId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));
    Task task = taskMapper.toEntity(dto, project, assignee);

    task = taskRepository.save(task);

    return taskMapper.toResponseDTO(task);
  }

  @Override
  public void deleteTask(Long id) {
    if (!taskRepository.existsById(id))
      throw new EntityNotFoundException("Task not found");
    taskRepository.deleteById(id);
  }

  @Override
  public List<TaskResponseDTO> getAllTasks() {
    List<Task> tasks = taskRepository.findAll();
    return taskMapper.toResponseDTOList(tasks);
  }

  @Override
  public TaskResponseDTO getTaskById(Long id) {
    Task task = taskRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

    return taskMapper.toResponseDTO(task);
  }

  @Override
  public TaskResponseDTO updateTask(Long id, UpdateTaskDTO dto) {
    Task task = taskRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Task not found"));

    if (dto.assigneeId() != null) {
      User assignee = userRepository.findById(dto.assigneeId())
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
      task.setAssignee(assignee);
    }
    if (dto.title() != null && !dto.title().isBlank())
      task.setTitle(dto.title());
    if (dto.description() != null && !dto.description().isBlank())
      task.setDescription(dto.description());
    if (dto.title() != null && !dto.title().isBlank())
      task.setTitle(dto.title());
    if (dto.deadline() != null)
      task.setDeadline(dto.deadline());
    if (dto.priority() != null)
      task.setPriority(dto.priority());

    taskRepository.save(task);
    return taskMapper.toResponseDTO(task);
  }

}
