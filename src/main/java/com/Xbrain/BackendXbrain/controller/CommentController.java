package com.Xbrain.BackendXbrain.controller;




import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<Optional<Object>> createComment(@PathVariable(value = "postId") Long postId, @RequestBody CommentEntity comment)  {
        ResponseEntity<Optional<Object>> response =commentService.create(postId,comment);

        return response;
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<Optional<CommentEntity>> getCommentById(@PathVariable Long id) {
        ResponseEntity<Optional<CommentEntity>> postById = commentService.getCommentById(id);
        return postById;
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentEntity>> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        List<CommentEntity> comments = commentService.getAllCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable Long id) {
        ResponseEntity<HttpStatus> response = commentService.deleteComment(id);

        return response;
    }





}







