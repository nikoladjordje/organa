package com.organa.dto.request.create;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CreateUserDTO(
    @Schema(description = "Username of the user") @NotBlank String username,
    @Schema(description = "Email of the user") @NotBlank @Email String email,
    @Schema(description = "Password of the user") @NotBlank String password) {
}
