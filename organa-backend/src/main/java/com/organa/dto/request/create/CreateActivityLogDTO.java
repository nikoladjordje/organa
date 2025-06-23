package com.organa.dto.request.create;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CreateActivityLogDTO(
    @Schema(description = "Id of the project") Long projectId,
    @Schema(description = "Id of the task") Long taskId,
    @Schema(description = "Id of the user") Long userId,
    @Schema(description = "Action") String action,
    @Schema(description = "Timestamp") LocalDateTime timestamp) {
}
