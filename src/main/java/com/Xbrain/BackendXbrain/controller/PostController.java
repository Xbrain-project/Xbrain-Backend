package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.bussiness.PostBusiness;
import com.Xbrain.BackendXbrain.dto.MPostresponse;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.exception.BaseException;
import com.Xbrain.BackendXbrain.repository.CommentRepository;
import com.Xbrain.BackendXbrain.repository.PostRepository;
import com.Xbrain.BackendXbrain.services.PostService;
import com.Xbrain.BackendXbrain.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PostController  {

    private final PostBusiness postBusiness;
    private final PostService postService;
    private final TestService testService;

    public PostController(PostBusiness postBusiness, PostService postService, TestService testService) {
        this.postBusiness = postBusiness;
        this.postService = postService;
        this.testService = testService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<MPostresponse> addPost(@PathVariable(value = "userId") Long userId, @RequestBody PostEntity postEntity) throws BaseException {
        MPostresponse response = postBusiness.create(postEntity, userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostEntity>> getPosts(@RequestParam(required = false) String title) {
        List<PostEntity> allPosts = postService.getAllPosts();

        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

//    @GetMapping("/posts/{id}")
//    public ResponseEntity<MPostresponse> getPostById(@PathVariable String id) {
//        MPostresponse response  = postBusiness.getPostById(id);
//        return ResponseEntity.ok(response);
//    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable String id) {

        Object response  = testService.getEntityById("POST",id);
        return ResponseEntity.ok(response);
    }

//    @DeleteMapping("/posts/{id}")
//    public ResponseEntity<HttpStatus> deletePost(@PathVariable String id) {
//        ResponseEntity<HttpStatus> response = postService.deletePost(id);
//
//        return response;
//    }


}







