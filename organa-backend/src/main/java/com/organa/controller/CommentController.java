package com.organa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organa.dto.request.create.CreateCommentDTO;
import com.organa.dto.request.update.UpdateCommentDTO;
import com.organa.dto.response.CommentResponseDTO;
import com.organa.service.CommentService;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {
  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PostMapping()
  public ResponseEntity<CommentResponseDTO> createComment(@RequestBody CreateCommentDTO createCommentDTO) {
    CommentResponseDTO response = commentService.createComment(createCommentDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CommentResponseDTO> getCommentById(@PathVariable Long id) {
    CommentResponseDTO response = commentService.getCommentById(id);
    return ResponseEntity.ok(response);
  }

  @GetMapping()
  public ResponseEntity<List<CommentResponseDTO>> getAllComments() {
    List<CommentResponseDTO> response = commentService.getAllComments();
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CommentResponseDTO> updateComment(@PathVariable Long id,
      @RequestBody UpdateCommentDTO updateCommentDTO) {
    CommentResponseDTO response = commentService.updateComment(id, updateCommentDTO);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    commentService.deleteComment(id);
    return ResponseEntity.noContent().build();
  }

}
