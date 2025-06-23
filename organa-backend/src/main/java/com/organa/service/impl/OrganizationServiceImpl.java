package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateOrganizationDTO;
import com.organa.dto.request.update.UpdateOrganizationDTO;
import com.organa.entity.Organization;
import com.organa.mapper.OrganizationMapper;
import com.organa.repository.OrganizationRepository;
import com.organa.service.OrganizationService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrganizationServiceImpl implements OrganizationService {

  private final OrganizationRepository organizationRepository;
  private final OrganizationMapper organizationMapper;

  public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
    this.organizationRepository = organizationRepository;
    this.organizationMapper = organizationMapper;
  }

  @Override
  public Organization createOrganization(CreateOrganizationDTO dto) {
    Organization organization = organizationMapper.toEntity(dto);
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

  @Override
  public void deleteOrganization(Long id) {
    if (!organizationRepository.existsById(id)) {
      throw new EntityNotFoundException("Organization with id " + id + " not found");
    }
    organizationRepository.deleteById(id);
  }

  @Override
  public Organization updateOrganization(Long id, UpdateOrganizationDTO dto) {
    Organization organization = organizationRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Organization not found"));
    if (dto.name() != null && !dto.name().isBlank())
      organization.setName(dto.name());

    organizationRepository.save(organization);
    return null;
  }

}
