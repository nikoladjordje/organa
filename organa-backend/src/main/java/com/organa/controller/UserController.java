package com.organa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organa.dto.request.CreateUserDTO;
import com.organa.dto.response.UserResponseDTO;
import com.organa.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping()
  public ResponseEntity<UserResponseDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
    UserResponseDTO response = userService.createUser(createUserDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {
    UserResponseDTO response = userService.getUserById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping()
  public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
    List<UserResponseDTO> response = userService.getAllUsers();
    return ResponseEntity.ok(response);
  }
}
