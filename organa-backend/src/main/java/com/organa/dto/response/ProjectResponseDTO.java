package com.organa.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record ProjectResponseDTO(
    @Schema(description = "Id of the Project") Long id,
    @Schema(description = "Id of the organization") Long organizationId,
    @Schema(description = "Name of the organization") String organizationName,
    @Schema(description = "Name of the Project") String name,
    @Schema(description = "Project's description") String description) {
}
