package com.organa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organa.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
