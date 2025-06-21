package com.organa.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;

public record UpdateCommentDTO(
    @Schema(description = "Comment content") String content) {
}
