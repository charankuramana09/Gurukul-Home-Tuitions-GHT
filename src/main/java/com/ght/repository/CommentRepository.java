package com.ght.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ght.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
