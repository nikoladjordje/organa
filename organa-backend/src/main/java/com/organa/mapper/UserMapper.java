package com.organa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.organa.dto.request.create.CreateUserDTO;
import com.organa.dto.response.UserResponseDTO;
import com.organa.entity.User;

@Component
public class UserMapper {

  public User toEntity(CreateUserDTO createUserDTO) {
    User user = new User();
    user.setUsername(createUserDTO.username());
    user.setEmail(createUserDTO.email());
    user.setPassword(createUserDTO.password());
    return user;
  }

  public UserResponseDTO toResponseDTO(User user) {
    UserResponseDTO responseDTO = new UserResponseDTO(user.getId(), user.getUsername(), user.getEmail());
    return responseDTO;
  }

  public List<UserResponseDTO> toResponseDTOList(List<User> users) {
    return users.stream().map(this::toResponseDTO).collect(Collectors.toList());
  }
}
