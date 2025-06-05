package com.organa.dto.request;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record CreateUserDTO(
    @Schema(description = "Username of the user") String username,
    @Schema(description = "Email of the user") String email,
    @Schema(description = "Password of the user") String password) {
  public CreateUserDTO {
    Objects.requireNonNull(username, "Username must not be null");
    Objects.requireNonNull(email, "Email must not be null");
    Objects.requireNonNull(password, "Password must not be null");
  }
}
