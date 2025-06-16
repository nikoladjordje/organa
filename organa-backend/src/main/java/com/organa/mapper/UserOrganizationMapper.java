package com.organa.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.organa.dto.request.create.CreateUserOrganizationDTO;
import com.organa.dto.response.UserOrganizationResponseDTO;
import com.organa.entity.Organization;
import com.organa.entity.User;
import com.organa.entity.UserOrganization;

@Component
public class UserOrganizationMapper {

  public UserOrganization toEntity(CreateUserOrganizationDTO dto, User user, Organization organization) {
    UserOrganization userOrganization = new UserOrganization();
    userOrganization.setUser(user);
    userOrganization.setOrganization(organization);
    userOrganization.setRole(dto.role());
    userOrganization.setAccepted(false);
    userOrganization.setInvitedAt(LocalDateTime.now());
    userOrganization.setAcceptedAt(null);
    userOrganization.setInvitedByEmail(dto.invitedByEmail());
    return userOrganization;
  }

  public UserOrganizationResponseDTO toResponseDTO(UserOrganization userOrganization) {
    return new UserOrganizationResponseDTO(userOrganization.getId(), userOrganization.getUser().getId(),
        userOrganization.getUser().getUsername(), userOrganization.getUser().getEmail(),
        userOrganization.getOrganization().getId(), userOrganization.getOrganization().getName(),
        userOrganization.getRole(), userOrganization.isAccepted(), userOrganization.getInvitedAt(),
        userOrganization.getAcceptedAt(), userOrganization.getInvitedByEmail());
  }

  public List<UserOrganizationResponseDTO> toResponseDTOList(List<UserOrganization> userOrganizations) {
    return userOrganizations.stream().map(this::toResponseDTO).collect(Collectors.toList());
  }

}
