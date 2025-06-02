package com.organa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organa.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
