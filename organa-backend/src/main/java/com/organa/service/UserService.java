package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateUserDTO;
import com.organa.dto.request.update.UpdateUserDTO;
import com.organa.dto.response.UserResponseDTO;
import com.organa.entity.User;

public interface UserService {

  UserResponseDTO createUser(CreateUserDTO createUserDTO);

  UserResponseDTO getUserById(Long id);

  List<UserResponseDTO> getAllUsers();

  UserResponseDTO updateUser(Long id, UpdateUserDTO dto);

  void deleteUser(Long id);

}
