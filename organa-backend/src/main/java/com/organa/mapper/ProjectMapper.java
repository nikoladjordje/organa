package com.organa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.organa.dto.request.create.CreateProjectDTO;
import com.organa.dto.response.ProjectResponseDTO;
import com.organa.entity.Organization;
import com.organa.entity.Project;

@Component
public class ProjectMapper {

  public Project toEntity(CreateProjectDTO dto, Organization org) {
    Project project = new Project();
    project.setOrganization(org);
    project.setName(dto.name());
    project.setDescription(dto.description());
    project.setDeleted(false);
    return project;
  }

  public ProjectResponseDTO toResponseDTO(Project project) {
      return new ProjectResponseDTO(project.getId(), project.getOrganization().getId(),
          project.getOrganization().getName(), project.getName(), project.getDescription());
  }

  public List<ProjectResponseDTO> toResponseDTOList(List<Project> projects) {
    return projects.stream().map(this::toResponseDTO).collect(Collectors.toList());
  }

}
