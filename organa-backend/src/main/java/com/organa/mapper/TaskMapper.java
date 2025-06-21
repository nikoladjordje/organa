package com.organa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.organa.dto.request.create.CreateTaskDTO;
import com.organa.dto.response.TaskResponseDTO;
import com.organa.entity.Project;
import com.organa.entity.Task;
import com.organa.entity.User;
import com.organa.enums.TaskStatus;

@Component
public class TaskMapper {
  public Task toEntity(CreateTaskDTO createTaskDTO, Project project, User assignee) {
    Task task = new Task();
    task.setProject(project);
    task.setAssignee(assignee);
    task.setTitle(createTaskDTO.title());
    task.setDescription(createTaskDTO.description());
    task.setStatus(TaskStatus.OPEN);
    task.setDeadline(createTaskDTO.deadline());
    task.setPriority(createTaskDTO.priority());
    task.setDeleted(false);
    return task;
  }

  public TaskResponseDTO toResponseDTO(Task task) {
    TaskResponseDTO responseDTO = new TaskResponseDTO(task.getId(), task.getProject().getId(),
        task.getAssignee().getId(),
        task.getTitle(), task.getDescription(), task.getDeadline(), task.getPriority());
    return responseDTO;
  }

  public List<TaskResponseDTO> toResponseDTOList(List<Task> tasks) {
    return tasks.stream().map(this::toResponseDTO).collect(Collectors.toList());
  }

}
