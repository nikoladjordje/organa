package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateActivityLogDTO;
import com.organa.dto.request.update.UpdateActivityLogDTO;
import com.organa.dto.response.ActivityLogResponseDTO;
import com.organa.entity.ActivityLog;
import com.organa.entity.Project;
import com.organa.entity.Task;
import com.organa.entity.User;
import com.organa.mapper.ActivityLogMapper;
import com.organa.repository.ActivityLogRepository;
import com.organa.repository.ProjectRepository;
import com.organa.repository.TaskRepository;
import com.organa.repository.UserRepository;
import com.organa.service.ActivityLogService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
  private final ActivityLogRepository activityLogRepository;
  private final ActivityLogMapper activityLogMapper;
  private final ProjectRepository projectRepository;
  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  public ActivityLogServiceImpl(ActivityLogRepository activityLogRepository, ActivityLogMapper activityLogMapper,
      ProjectRepository projectRepository, TaskRepository taskRepository, UserRepository userRepository) {
    this.activityLogRepository = activityLogRepository;
    this.activityLogMapper = activityLogMapper;
    this.projectRepository = projectRepository;
    this.taskRepository = taskRepository;
    this.userRepository = userRepository;
  }

  @Override
  public ActivityLogResponseDTO createLog(CreateActivityLogDTO dto) {
    User user = userRepository.findById(dto.userId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    Task task = taskRepository.findById(dto.taskId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
    Project project = projectRepository.findById(dto.projectId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));

    ActivityLog log = activityLogMapper.toEntity(dto, project, task, user);
    log = activityLogRepository.save(log);

    return activityLogMapper.toResponseDTO(log);
  }

  @Override
  public void deleteLog(Long id) {

    if (!activityLogRepository.existsById(id))
      throw new EntityNotFoundException("ActivityLog not found");
    activityLogRepository.deleteById(id);
  }

  @Override
  public List<ActivityLogResponseDTO> getAllLogs() {
    List<ActivityLog> logs = activityLogRepository.findAll();
    return activityLogMapper.toResponseDTOList(logs);
  }

  @Override
  public ActivityLogResponseDTO getLogById(Long id) {
    ActivityLog log = activityLogRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ActivityLog not found"));

    return activityLogMapper.toResponseDTO(log);
  }

  @Override
  public ActivityLogResponseDTO updateLog(Long id, UpdateActivityLogDTO dto) {
    ActivityLog log = activityLogRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ActivityLog not found"));

    if (dto.action() != null && !dto.action().isBlank())
      log.setAction(dto.action());

    activityLogRepository.save(log);
    return activityLogMapper.toResponseDTO(log);
  }

}
