package com.organa.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UpdateProjectDTO(
    @Schema(description = "Name of the Project") String name,
    @Schema(description = "Project's description") String description) {
}
