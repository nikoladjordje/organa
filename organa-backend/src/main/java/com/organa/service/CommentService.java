package com.organa.service;

import java.util.List;

import com.organa.dto.request.create.CreateCommentDTO;
import com.organa.dto.request.update.UpdateCommentDTO;
import com.organa.dto.response.CommentResponseDTO;

public interface CommentService {

  CommentResponseDTO createComment(CreateCommentDTO dto);

  CommentResponseDTO getCommentById(Long id);

  List<CommentResponseDTO> getAllComments();

  CommentResponseDTO updateComment(Long id, UpdateCommentDTO dto);

  void deleteComment(Long id);

}
