package com.organa.dto.request.update;

import com.organa.enums.UserOrganizationRole;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserOrganizationDTO(@Schema(description = "Role of the user") @NotBlank UserOrganizationRole role) {
}
