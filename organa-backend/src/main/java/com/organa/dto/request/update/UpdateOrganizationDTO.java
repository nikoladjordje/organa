package com.organa.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UpdateOrganizationDTO(@Schema(description = "Name of the organization") @NotBlank String name) {
}
