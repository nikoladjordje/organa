package com.organa.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UpdateActivityLogDTO(
    @Schema(description = "Action") String action) {
}
