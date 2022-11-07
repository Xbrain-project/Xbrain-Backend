package com.Xbrain.BackendXbrain.Controller;




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


    @PostMapping("/{postId}")
    public ResponseEntity<Optional<Object>> createComment(@PathVariable(value = "postId") Long postId, @RequestBody CommentEntity comment)  {
        ResponseEntity<Optional<Object>> response =commentService.create(postId,comment);

        return response;
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<CommentEntity>> getAllCommentsByPostId(@PathVariable(value = "postId") Long postId) {
        List<CommentEntity> comments = commentService.getAllCommentsByPostId(postId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

//    @GetMapping("/")
//    public ResponseEntity<List<PostEntity>> getPosts(@RequestParam(required = false) String title) {
//        List<PostEntity> allPosts = postService.getAllPosts();
//
//        return new ResponseEntity<>(allPosts, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<PostEntity>> getPostById(@PathVariable Long id) {
//        ResponseEntity<Optional<PostEntity>> postById = postService.getPostById(id);
//        return postById;
//    }
//
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id) {
//        ResponseEntity<HttpStatus> response = postService.deletePost(id);
//
//        return response;
//    }


}







