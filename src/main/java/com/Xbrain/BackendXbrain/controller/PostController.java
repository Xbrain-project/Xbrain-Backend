package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.bussiness.PostBusiness;
import com.Xbrain.BackendXbrain.dto.MPostresponse;
import com.Xbrain.BackendXbrain.dto.PostRequest;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.exception.BaseExceptionImpl;
import com.Xbrain.BackendXbrain.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class PostController  {

    private final PostBusiness postBusiness;
    private final PostService postService;

    public PostController(PostBusiness postBusiness, PostService postService) {
        this.postBusiness = postBusiness;
        this.postService = postService;
    }

    @PostMapping("/users/post")
    public ResponseEntity<MPostresponse> addPost(@RequestBody PostRequest postRequest) throws BaseExceptionImpl {

        MPostresponse response = postBusiness.create(postRequest);
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

//        Object response  = testService.getEntityById("POST",id);
        MPostresponse response = postBusiness.getPostById(id);
        return ResponseEntity.ok(response);

    }

//    @DeleteMapping("/posts/{id}")
//    public ResponseEntity<HttpStatus> deletePost(@PathVariable String id) {
//        ResponseEntity<HttpStatus> response = postService.deletePost(id);
//
//        return response;
//    }


}







