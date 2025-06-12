package com.organa.dto.response;

import java.time.LocalDateTime;

import com.organa.enums.UserOrganizationRole;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserOrganizationResponseDTO(
    @Schema(description = "Id of the user-organization relation") Long id,
    @Schema(description = "Id of the user") Long userId,
    @Schema(description = "Username of the user") String username,
    @Schema(description = "Email of the user") String userEmail,
    @Schema(description = "Id of the organization") Long organizationId,
    @Schema(description = "Name of the organization") String organizationName,
    @Schema(description = "Role of the user in the organization") UserOrganizationRole role,
    @Schema(description = "Whether or not the user is accepted") boolean accepted,
    @Schema(description = "Date and Time when the user was invited") LocalDateTime invitedAt,
    @Schema(description = "Date and Time when the user was accepted") LocalDateTime acceptedAt,
    @Schema(description = "Inviter's email") String invitedByEmail) {
}
