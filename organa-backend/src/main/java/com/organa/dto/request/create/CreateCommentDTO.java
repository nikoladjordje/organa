package com.organa.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CreateCommentDTO(
    @Schema(description = "Id of the user") Long userId,
    @Schema(description = "Id of the task") Long taskId,
    @Schema(description = "Comment content") String content) {
}
