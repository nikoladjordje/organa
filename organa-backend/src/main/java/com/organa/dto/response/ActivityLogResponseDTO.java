package com.organa.dto.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record ActivityLogResponseDTO(
    @Schema(description = "Id of the log") Long id,
    @Schema(description = "Id of the project") Long projectId,
    @Schema(description = "Id of the task") Long taskId,
    @Schema(description = "Id of the user") Long userId,
    @Schema(description = "Action") String action,
    @Schema(description = "Timestamp") LocalDateTime timestamp) {
}
