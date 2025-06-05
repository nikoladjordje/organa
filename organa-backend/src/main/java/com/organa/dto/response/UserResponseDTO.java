package com.organa.dto.response;

import com.organa.entity.User;

import lombok.Builder;

@Builder
public record UserResponseDTO(Long id, String username, String email) {
  public static UserResponseDTO from(User user) {
    return UserResponseDTO.builder().id(user.getId()).username(user.getUsername()).email(user.getEmail()).build();
  }
}
