package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateOrganizationDTO;
import com.organa.dto.request.update.UpdateOrganizationDTO;
import com.organa.entity.Organization;

public interface OrganizationService {

  Organization createOrganization(CreateOrganizationDTO dto);

  Organization getOrganizationById(Long id);

  List<Organization> getAllOrganizations();

  Organization updateOrganization(Long id, UpdateOrganizationDTO dto);

  void deleteOrganization(Long id);
}
