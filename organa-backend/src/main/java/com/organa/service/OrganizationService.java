package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateOrganizationDTO;
import com.organa.entity.Organization;

public interface OrganizationService {

  Organization createOrganization(CreateOrganizationDTO createOrganizationDTO);

  Organization getOrganizationById(Long id);

  List<Organization> getAllOrganizations();
}
