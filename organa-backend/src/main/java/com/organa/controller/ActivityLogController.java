package com.organa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organa.dto.request.create.CreateActivityLogDTO;
import com.organa.dto.request.update.UpdateActivityLogDTO;
import com.organa.dto.response.ActivityLogResponseDTO;
import com.organa.service.ActivityLogService;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {
  private final ActivityLogService activityLogService;

  public ActivityLogController(ActivityLogService activityLogService) {
    this.activityLogService = activityLogService;
  }

  @PostMapping()
  public ResponseEntity<ActivityLogResponseDTO> createActivityLog(
      @RequestBody CreateActivityLogDTO createActivityLogDTO) {
    ActivityLogResponseDTO response = activityLogService.createLog(createActivityLogDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ActivityLogResponseDTO> getActivityLogById(@PathVariable Long id) {
    ActivityLogResponseDTO response = activityLogService.getLogById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping()
  public ResponseEntity<List<ActivityLogResponseDTO>> getAllActivityLogs() {
    List<ActivityLogResponseDTO> response = activityLogService.getAllLogs();
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ActivityLogResponseDTO> updateActivityLog(@PathVariable Long id,
      @RequestBody UpdateActivityLogDTO updateActivityLogDTO) {
    ActivityLogResponseDTO response = activityLogService.updateLog(id, updateActivityLogDTO);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    activityLogService.deleteLog(id);
    return ResponseEntity.noContent().build();
  }
}
