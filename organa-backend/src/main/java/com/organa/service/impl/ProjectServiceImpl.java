package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateProjectDTO;
import com.organa.dto.response.ProjectResponseDTO;
import com.organa.entity.Organization;
import com.organa.entity.Project;
import com.organa.mapper.ProjectMapper;
import com.organa.repository.OrganizationRepository;
import com.organa.repository.ProjectRepository;
import com.organa.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
  private final ProjectRepository projectRepository;
  private final OrganizationRepository organizationRepository;
  private final ProjectMapper projectMapper;

  public ProjectServiceImpl(ProjectRepository projectRepository, OrganizationRepository organizationRepository,
      ProjectMapper projectMapper) {
    this.projectRepository = projectRepository;
    this.organizationRepository = organizationRepository;
    this.projectMapper = projectMapper;
  }

  @Override
  public ProjectResponseDTO createProject(CreateProjectDTO createProjectDTO) {
    Organization org = organizationRepository.findById(createProjectDTO.organizationId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found"));

    Project project = projectMapper.toEntity(createProjectDTO, org);
    project = projectRepository.save(project);
    return projectMapper.toResponseDTO(project);
  }

  @Override
  public List<ProjectResponseDTO> getAllProjects() {
    List<Project> projects = projectRepository.findAll();
    return projectMapper.toResponseDTOList(projects);
  }

  @Override
  public ProjectResponseDTO getProjectById(Long id) {
    Project project = projectRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found"));
    return projectMapper.toResponseDTO(project);
  }

}
