package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.entity.PostEntity;

import com.Xbrain.BackendXbrain.services.PostService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin("http://localhost:3000")
@RestController
//@RequestMapping("/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

//    @PostMapping("/post")
//    public Post addPost(@RequestParam Map<String,String> requestParams
//    ) throws Exception {
//        String strPost = requestParams.get("post");
//        String email = requestParams.get("email");
//        String name = requestParams.get("name");
//
//        Post post = Post.builder()
//                .name(name)
//                .email(email)
//                .post(strPost)
//                .timeStamp(new Date().toString())
//                .build();
//        post = postService.addPost(post);
//        return post;
//    }
    @PostMapping("/post")
    public PostEntity addPost(@RequestBody PostEntity postEntity) throws Exception {
        return postService.addPost(postEntity);
    }

    @GetMapping
    public List<PostEntity> getPost(){
        return postService.getPost();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<Optional<PostEntity>> getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id){
        return postService.deletePost(id);
    }

}
