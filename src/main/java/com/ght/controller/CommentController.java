package com.ght.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ght.model.Comment;
import com.ght.service.CommentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200") // Update with your Angular app's URL
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments") // Changed endpoint to a more RESTful style
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.saveComment(comment);
    }
}
