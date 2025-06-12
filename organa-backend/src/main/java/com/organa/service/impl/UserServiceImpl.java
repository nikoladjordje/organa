package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateUserDTO;
import com.organa.dto.request.update.UpdateUserDTO;
import com.organa.dto.response.UserResponseDTO;
import com.organa.entity.User;
import com.organa.mapper.UserMapper;
import com.organa.repository.UserRepository;
import com.organa.service.UserService;

import jakarta.persistence.EntityNotFoundException;

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

  @Override
  public UserResponseDTO updateUser(Long id, UpdateUserDTO dto) {
    User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

    if (dto.username() != null)
      user.setUsername(dto.username());
    if (dto.email() != null)
      user.setEmail(dto.email());
    if (dto.password() != null)
      user.setPassword(dto.password());

    userRepository.save(user);
    return userMapper.toResponseDTO(user);
  }

  @Override
  public void deleteUser(Long id) {
    if (!userRepository.existsById(id)) {
      throw new EntityNotFoundException("User with id " + id + " not found");
    }
    userRepository.deleteById(id);
  }
}
