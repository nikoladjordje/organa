package com.organa.dto.response;

import com.organa.entity.User;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UserResponseDTO(
    @Schema(description = "Id of the user") Long id,
    @Schema(description = "Username of the user") String username,
    @Schema(description = "Email of the user") String email) {
  public static UserResponseDTO from(User user) {
    return UserResponseDTO.builder().id(user.getId()).username(user.getUsername()).email(user.getEmail()).build();
  }
}
