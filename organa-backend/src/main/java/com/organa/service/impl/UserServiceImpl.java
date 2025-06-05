package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.CreateUserDTO;
import com.organa.dto.response.UserResponseDTO;
import com.organa.entity.User;
import com.organa.mapper.UserMapper;
import com.organa.repository.UserRepository;
import com.organa.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserResponseDTO createUser(CreateUserDTO createUserDTO) {
    User user = userMapper.toEntity(createUserDTO);
    user = userRepository.save(user);

    return userMapper.toResponseDTO(user);
  }

  @Override
  public UserResponseDTO getUserById(Long id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

    return userMapper.toResponseDTO(user);
  }

  @Override
  public List<UserResponseDTO> getAllUsers() {
    List<User> users = userRepository.findAll();
    return userMapper.toResponseDTOList(users);
  }

}
