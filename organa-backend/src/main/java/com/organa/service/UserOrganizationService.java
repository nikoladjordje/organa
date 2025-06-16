package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateUserOrganizationDTO;
import com.organa.dto.response.UserOrganizationResponseDTO;

public interface UserOrganizationService {

  UserOrganizationResponseDTO createUserOrganization(CreateUserOrganizationDTO createUserOrganizationDTO);

  UserOrganizationResponseDTO getUserOrganizationById(Long id);

  List<UserOrganizationResponseDTO> getAllUserOrganizations();

}
