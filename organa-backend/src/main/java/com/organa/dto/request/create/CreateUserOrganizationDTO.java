package com.organa.dto.request.create;

import com.organa.enums.UserOrganizationRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateUserOrganizationDTO(
    @Schema(description = "Id of the user") @NotBlank Long userId,
    @Schema(description = "Id of the organization") @NotBlank Long organizationId,
    @Schema(description = "Role of the user") @NotBlank UserOrganizationRole role,
    @Schema(description = "Inviter's email") @NotBlank String invitedByEmail) {

}
