package com.organa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organa.dto.request.CreateOrganizationDTO;
import com.organa.entity.Organization;
import com.organa.service.OrganizationService;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
  private final OrganizationService organizationService;

  public OrganizationController(OrganizationService organizationService) {
    this.organizationService = organizationService;
  }

  @PostMapping()
  public ResponseEntity<Organization> createOrganization(@RequestBody CreateOrganizationDTO createOrganizationDTO) {
    Organization response = organizationService.createOrganization(createOrganizationDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Organization> getOrganizationById(@PathVariable Long id) {
    Organization response = organizationService.getOrganizationById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping()
  public ResponseEntity<List<Organization>> getAllUsers() {
    List<Organization> response = organizationService.getAllOrganizations();
    return ResponseEntity.ok(response);
  }
}
