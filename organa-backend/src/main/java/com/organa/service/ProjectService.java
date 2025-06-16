package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateProjectDTO;
import com.organa.dto.response.ProjectResponseDTO;

public interface ProjectService {
  ProjectResponseDTO createProject(CreateProjectDTO createProjectDTO);

  ProjectResponseDTO getProjectById(Long id);

  List<ProjectResponseDTO> getAllProjects();
}
