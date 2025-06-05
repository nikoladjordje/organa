package com.organa.service;

import java.util.List;

import com.organa.dto.request.CreateUserDTO;
import com.organa.dto.response.UserResponseDTO;

public interface UserService {

  UserResponseDTO createUser(CreateUserDTO createUserDTO);

  UserResponseDTO getUserById(Long id);

  List<UserResponseDTO> getAllUsers();

}
