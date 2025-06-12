package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateOrganizationDTO;
import com.organa.entity.Organization;
import com.organa.mapper.OrganizationMapper;
import com.organa.repository.OrganizationRepository;
import com.organa.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  private final OrganizationRepository organizationRepository;
  private final OrganizationMapper organizationMapper;

  public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
    this.organizationRepository = organizationRepository;
    this.organizationMapper = organizationMapper;
  }

  @Override
  public Organization createOrganization(CreateOrganizationDTO createOrganizationDTO) {
    Organization organization = organizationMapper.toEntity(createOrganizationDTO);
    organization = organizationRepository.save(organization);
    return organization;
  }

  @Override
  public List<Organization> getAllOrganizations() {
    List<Organization> organizations = organizationRepository.findAll();
    return organizations;
  }

  @Override
  public Organization getOrganizationById(Long id) {
    Organization organization = organizationRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    return organization;
  }
}
