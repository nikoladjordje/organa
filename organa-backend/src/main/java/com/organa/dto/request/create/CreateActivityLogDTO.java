package com.organa.dto.request.create;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateActivityLogDTO(
    @Schema(description = "Id of the project") @NotBlank Long projectId,
    @Schema(description = "Id of the task") @NotBlank Long taskId,
    @Schema(description = "Id of the user") @NotBlank Long userId,
    @Schema(description = "Action") @NotBlank String action,
    @Schema(description = "Timestamp") LocalDateTime timestamp) {
}
