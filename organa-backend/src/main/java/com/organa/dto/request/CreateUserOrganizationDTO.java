package com.organa.dto.request;

import com.organa.enums.UserOrganizationRole;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateUserOrganizationDTO(
    @Schema(description = "Id of the user") Long userId,
    @Schema(description = "Id of the organization") Long organizationId,
    @Schema(description = "Role of the user") UserOrganizationRole role,
    @Schema(description = "Inviter's email") String invitedByEmail) {

}
