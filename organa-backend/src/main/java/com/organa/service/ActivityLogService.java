package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateActivityLogDTO;
import com.organa.dto.request.update.UpdateActivityLogDTO;
import com.organa.dto.response.ActivityLogResponseDTO;

public interface ActivityLogService {
  ActivityLogResponseDTO createLog(CreateActivityLogDTO dto);

  ActivityLogResponseDTO getLogById(Long id);

  List<ActivityLogResponseDTO> getAllLogs();

  ActivityLogResponseDTO updateLog(Long id, UpdateActivityLogDTO dto);

  void deleteLog(Long id);
}
