package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Optional<Object>> addPost(@PathVariable(value = "userId") Long userId, @RequestBody PostEntity postEntity)  {
        ResponseEntity<Optional<Object>> response =postService.addPost(userId,postEntity);

        return response;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostEntity>> getPosts(@RequestParam(required = false) String title) {
        List<PostEntity> allPosts = postService.getAllPosts();

        return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<PostEntity>> getPostById(@PathVariable Long id) {
        ResponseEntity<Optional<PostEntity>> postById = postService.getPostById(id);
        return postById;
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id) {
        ResponseEntity<HttpStatus> response = postService.deletePost(id);

        return response;
    }


}







