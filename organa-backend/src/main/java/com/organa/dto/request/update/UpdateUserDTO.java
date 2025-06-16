package com.organa.dto.request.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UpdateUserDTO(
    @Schema(description = "Username of the user") String username,
    @Schema(description = "Email of the user") String email,
    @Schema(description = "Password of the user") String password) {
}
