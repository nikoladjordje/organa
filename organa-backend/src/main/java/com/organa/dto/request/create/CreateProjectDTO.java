package com.organa.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateProjectDTO(
    @Schema(description = "Organization id of the Project") @NotBlank Long organizationId,
    @Schema(description = "Name of the Project") @NotBlank String name,
    @Schema(description = "Project's description") String description) {
}
