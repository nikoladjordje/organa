package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateProjectDTO;
import com.organa.dto.request.update.UpdateProjectDTO;
import com.organa.dto.response.ProjectResponseDTO;
import com.organa.entity.Organization;
import com.organa.entity.Project;
import com.organa.mapper.ProjectMapper;
import com.organa.repository.OrganizationRepository;
import com.organa.repository.ProjectRepository;
import com.organa.service.ProjectService;

import jakarta.persistence.EntityNotFoundException;

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

  @Override
  public void deleteProject(Long id) {
    if (!projectRepository.existsById(id)) {
      throw new EntityNotFoundException("User with id " + id + " not found");
    }
    projectRepository.deleteById(id);

  }

  @Override
  public ProjectResponseDTO updateProject(Long id, UpdateProjectDTO dto) {
    Project project = projectRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Project not found"));

    if (dto.name() != null && !dto.name().isBlank())
      project.setName(dto.name());
    if (dto.description() != null && !dto.description().isBlank())
      project.setDescription(dto.description());

    projectRepository.save(project);
    return projectMapper.toResponseDTO(project);
  }

}
