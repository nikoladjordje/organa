package com.organa.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateCommentDTO(
    @Schema(description = "Id of the user") @NotBlank Long userId,
    @Schema(description = "Id of the task") @NotBlank Long taskId,
    @Schema(description = "Comment content") @NotBlank String content) {
}
