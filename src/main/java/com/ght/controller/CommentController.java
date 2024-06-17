package com.ght.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.Comment;
import com.ght.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/postComment")
	public Comment createComment( @RequestBody Comment comment) {
		
		return commentService.saveComment(comment);
	}
	
	@GetMapping("/fecthpostById/{id}")
	public Comment getCommentById(@PathVariable Long id) {
		return commentService.findById(id);
	}
	
	

}
