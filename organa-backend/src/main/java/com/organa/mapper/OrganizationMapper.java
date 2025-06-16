package com.organa.mapper;

import org.springframework.stereotype.Component;

import com.organa.dto.request.create.CreateOrganizationDTO;
import com.organa.entity.Organization;

@Component
public class OrganizationMapper {

  public Organization toEntity(CreateOrganizationDTO createOrganizationDTO) {
    Organization organization = new Organization();
    organization.setName(createOrganizationDTO.name());
    return organization;
  }

}
