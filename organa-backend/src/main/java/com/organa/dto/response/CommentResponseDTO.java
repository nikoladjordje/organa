package com.organa.dto.response;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CommentResponseDTO(
    @Schema(description = "Id of the comment") Long id,
    @Schema(description = "Id of the user") Long userId,
    @Schema(description = "Id of the task") Long taskId,
    @Schema(description = "Comment content") String content,
    @Schema(description = "Date of creation") LocalDateTime createdAt) {
}
