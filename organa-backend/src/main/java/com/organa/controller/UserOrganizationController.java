package com.organa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organa.dto.request.CreateUserOrganizationDTO;
import com.organa.dto.response.UserOrganizationResponseDTO;
import com.organa.service.UserOrganizationService;

@RestController
@RequestMapping("/api/user-orgs")
public class UserOrganizationController {
  private final UserOrganizationService userOrganizationService;

  public UserOrganizationController(UserOrganizationService userOrganizationService) {
    this.userOrganizationService = userOrganizationService;
  }

  @PostMapping()
  public ResponseEntity<UserOrganizationResponseDTO> createUserOrganization(
      CreateUserOrganizationDTO createUserOrganizationDTO) {
    UserOrganizationResponseDTO response = userOrganizationService.createUserOrganization(createUserOrganizationDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserOrganizationResponseDTO> getUserOrganizationById(@PathVariable Long id) {
    UserOrganizationResponseDTO response = userOrganizationService.getUserOrganizationById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping()
  public ResponseEntity<List<UserOrganizationResponseDTO>> getAllUserOrganizations() {
    List<UserOrganizationResponseDTO> response = userOrganizationService.getAllUserOrganizations();
    return ResponseEntity.ok(response);
  }

}
