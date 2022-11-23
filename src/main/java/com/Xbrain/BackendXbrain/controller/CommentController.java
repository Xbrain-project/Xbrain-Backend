package com.Xbrain.BackendXbrain.controller;
import com.Xbrain.BackendXbrain.bussiness.CommentBusiness;
import com.Xbrain.BackendXbrain.dto.CommentRequest;
import com.Xbrain.BackendXbrain.dto.CommentResponse;
import com.Xbrain.BackendXbrain.entity.CommentEntity;
import com.Xbrain.BackendXbrain.exception.BaseExceptionImpl;
import com.Xbrain.BackendXbrain.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")

public class CommentController {

    private final CommentBusiness commentBusiness;
    private final CommentService commentService;

    public CommentController(CommentBusiness commentBusiness, CommentService commentService) {
        this.commentBusiness = commentBusiness;
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentResponse> createComment(@PathVariable(value = "postId") String postId, @RequestBody CommentRequest request) throws BaseExceptionImpl {
        CommentResponse response =commentBusiness.create(postId,request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/comments/{id}")
    public ResponseEntity<CommentResponse> getCommentById(@PathVariable String id) {
        CommentResponse response = commentBusiness.getCommentById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts/{postId}/comments")
    public List<CommentEntity> getAllCommentsByPostId(@PathVariable(value = "postId") String postId) {
        List<CommentEntity> response = commentBusiness.getAllCommentsbyId(postId);
        return response;
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable String id) {
        ResponseEntity<HttpStatus> response = commentService.deleteComment(id);

        return response;
    }





}







