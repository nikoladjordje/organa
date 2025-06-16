package com.organa.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CreateProjectDTO(
    @Schema(description = "Organization id of the Project") Long organizationId,
    @Schema(description = "Name of the Project") String name,
    @Schema(description = "Project's description") String description) {
}
