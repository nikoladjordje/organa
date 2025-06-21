package com.organa.dto.response;

import java.time.LocalDateTime;

import com.organa.enums.TaskPriority;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record TaskResponseDTO(
    @Schema(description = "Id of the task") Long id,
    @Schema(description = "Id of the project") Long projectId,
    @Schema(description = "Id of the assigned user") Long assigneeId,
    @Schema(description = "Title of the task") String title,
    @Schema(description = "Task description") String description,
    @Schema(description = "Deadline of the task") LocalDateTime deadline,
    @Schema(description = "Task priority") TaskPriority priority) {
}
