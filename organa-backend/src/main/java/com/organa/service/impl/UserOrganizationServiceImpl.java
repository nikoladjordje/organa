package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.CreateUserOrganizationDTO;
import com.organa.dto.response.UserOrganizationResponseDTO;
import com.organa.entity.Organization;
import com.organa.entity.User;
import com.organa.entity.UserOrganization;
import com.organa.mapper.UserOrganizationMapper;
import com.organa.repository.OrganizationRepository;
import com.organa.repository.UserOrganizationRepository;
import com.organa.repository.UserRepository;
import com.organa.service.UserOrganizationService;

@Service
public class UserOrganizationServiceImpl implements UserOrganizationService {

  private final UserOrganizationRepository userOrganizationRepository;
  private final UserRepository userRepository;
  private final OrganizationRepository organizationRepository;
  private final UserOrganizationMapper userOrganizationMapper;

  public UserOrganizationServiceImpl(UserOrganizationRepository userOrganizationRepository,
      UserRepository userRepository, OrganizationRepository organizationRepository,
      UserOrganizationMapper userOrganizationMapper) {
    this.userOrganizationRepository = userOrganizationRepository;
    this.userRepository = userRepository;
    this.organizationRepository = organizationRepository;
    this.userOrganizationMapper = userOrganizationMapper;
  }

  @Override
  public UserOrganizationResponseDTO createUserOrganization(CreateUserOrganizationDTO dto) {
    User user = userRepository.findById(dto.userId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    Organization org = organizationRepository.findById(dto.organizationId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organization not found"));
    UserOrganization userOrg = userOrganizationMapper.toEntity(dto, user, org);
    userOrg = userOrganizationRepository.save(userOrg);
    return userOrganizationMapper.toResponseDTO(userOrg);
  }

  @Override
  public List<UserOrganizationResponseDTO> getAllUserOrganizations() {
    List<UserOrganization> userOrgs = userOrganizationRepository.findAll();
    return userOrganizationMapper.toResponseDTOList(userOrgs);
  }

  @Override
  public UserOrganizationResponseDTO getUserOrganizationById(Long id) {
    UserOrganization userOrg = userOrganizationRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User-organization not found"));

    return userOrganizationMapper.toResponseDTO(userOrg);
  }

}
