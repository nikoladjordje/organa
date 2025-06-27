package com.organa.dto.request.create;

import java.time.LocalDateTime;

import com.organa.enums.TaskPriority;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateTaskDTO(
    @Schema(description = "Id of the project") @NotBlank Long projectId,
    @Schema(description = "Id of the assigned user") @NotBlank Long assigneeId,
    @Schema(description = "Title of the task") @NotBlank String title,
    @Schema(description = "Task description") String description,
    @Schema(description = "Deadline of the task") @NotBlank LocalDateTime deadline,
    @Schema(description = "Task priority") @NotBlank TaskPriority priority) {
}
