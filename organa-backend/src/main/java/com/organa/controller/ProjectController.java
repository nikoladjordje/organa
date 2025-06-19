package com.organa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.organa.dto.request.create.CreateProjectDTO;
import com.organa.dto.request.update.UpdateProjectDTO;
import com.organa.dto.response.ProjectResponseDTO;
import com.organa.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
  private final ProjectService projectService;

  public ProjectController(ProjectService projectService) {
    this.projectService = projectService;
  }

  @PostMapping()
  public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody CreateProjectDTO createProjectDTO) {
    ProjectResponseDTO response = projectService.createProject(createProjectDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProjectResponseDTO> getProjectById(@PathVariable Long id) {
    ProjectResponseDTO response = projectService.getProjectById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping()
  public ResponseEntity<List<ProjectResponseDTO>> getAllUsers() {
    List<ProjectResponseDTO> response = projectService.getAllProjects();
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable Long id, @RequestBody UpdateProjectDTO dto) {
    ProjectResponseDTO response = projectService.updateProject(id, dto);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
    projectService.deleteProject(id);
    return ResponseEntity.noContent().build();
  }
}
