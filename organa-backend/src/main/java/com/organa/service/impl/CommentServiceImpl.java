package com.organa.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.organa.dto.request.create.CreateCommentDTO;
import com.organa.dto.request.update.UpdateCommentDTO;
import com.organa.dto.response.CommentResponseDTO;
import com.organa.entity.Comment;
import com.organa.entity.Task;
import com.organa.entity.User;
import com.organa.mapper.CommentMapper;
import com.organa.repository.CommentRepository;
import com.organa.repository.TaskRepository;
import com.organa.repository.UserRepository;
import com.organa.service.CommentService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {
  private final CommentRepository commentRepository;
  private final CommentMapper commentMapper;
  private final UserRepository userRepository;
  private final TaskRepository taskRepository;

  public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper,
      UserRepository userRepository, TaskRepository taskRepository) {
    this.commentRepository = commentRepository;
    this.commentMapper = commentMapper;
    this.userRepository = userRepository;
    this.taskRepository = taskRepository;
  }

  @Override
  public CommentResponseDTO createComment(CreateCommentDTO dto) {
    User user = userRepository.findById(dto.userId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    Task task = taskRepository.findById(dto.taskId())
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

    Comment comment = commentMapper.toEntity(dto, user, task);
    comment = commentRepository.save(comment);

    return commentMapper.toResponseDTO(comment);
  }

  @Override
  public void deleteComment(Long id) {
    if (!commentRepository.existsById(id))
      throw new EntityNotFoundException("Comment not found");
    commentRepository.deleteById(id);
  }

  @Override
  public List<CommentResponseDTO> getAllComments() {
    List<Comment> comments = commentRepository.findAll();
    return commentMapper.toResponseDTOList(comments);
  }

  @Override
  public CommentResponseDTO getCommentById(Long id) {
    Comment comment = commentRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));

    return commentMapper.toResponseDTO(comment);
  }

  @Override
  public CommentResponseDTO updateComment(Long id, UpdateCommentDTO dto) {
    Comment comment = commentRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));

    if (dto.content() != null && !dto.content().isBlank())
      comment.setContent(dto.content());

    commentRepository.save(comment);
    return commentMapper.toResponseDTO(comment);
  }

}
