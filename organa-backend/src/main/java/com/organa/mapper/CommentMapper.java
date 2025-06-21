package com.organa.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.organa.dto.request.create.CreateCommentDTO;
import com.organa.dto.response.CommentResponseDTO;
import com.organa.entity.Comment;
import com.organa.entity.Task;
import com.organa.entity.User;

@Component
public class CommentMapper {
  public Comment toEntity(CreateCommentDTO dto, User user, Task task) {
    Comment comment = new Comment();
    comment.setUser(user);
    comment.setTask(task);
    comment.setContent(dto.content());
    return comment;
  }

  public CommentResponseDTO toResponseDTO(Comment comment) {
    return new CommentResponseDTO(comment.getId(), comment.getUser().getId(), comment.getTask().getId(),
        comment.getContent(), comment.getCreatedAt());
  }

  public List<CommentResponseDTO> toResponseDTOList(List<Comment> comments) {
    return comments.stream().map(this::toResponseDTO).collect(Collectors.toList());
  }

}
