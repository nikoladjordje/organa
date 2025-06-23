package com.organa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.organa.dto.request.create.CreateActivityLogDTO;
import com.organa.dto.response.ActivityLogResponseDTO;
import com.organa.entity.ActivityLog;
import com.organa.entity.Project;
import com.organa.entity.Task;
import com.organa.entity.User;

@Component
public class ActivityLogMapper {
  public ActivityLog toEntity(CreateActivityLogDTO dto, Project project, Task task, User user) {
    ActivityLog activityLog = new ActivityLog();
    activityLog.setProject(project);
    activityLog.setTask(task);
    activityLog.setUser(user);
    activityLog.setAction(dto.action());
    activityLog.setTimestamp(dto.timestamp());
    return activityLog;
  }

  public ActivityLogResponseDTO toResponseDTO(ActivityLog activityLog) {
    return new ActivityLogResponseDTO(activityLog.getId(), activityLog.getProject().getId(),
        activityLog.getTask().getId(), activityLog.getUser().getId(), activityLog.getAction(),
        activityLog.getTimestamp());
  }

  public List<ActivityLogResponseDTO> toResponseDTOList(List<ActivityLog> logs) {
    return logs.stream().map(this::toResponseDTO).collect(Collectors.toList());
  }
}
