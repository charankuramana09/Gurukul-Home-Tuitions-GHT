package com.ght.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ght.model.Comment;
import com.ght.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepo;
	
	
	public Comment findById(Long Id){
		 Optional<Comment> byId = commentRepo.findById(Id);
		 return byId.get();
	}
	
	 public Comment saveComment(Comment comment) {
		 return commentRepo.save(comment);
	 }
	

	

}
