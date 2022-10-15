package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.model.Post;
import com.Xbrain.BackendXbrain.services.PostService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:3000")
@RestController
//@RequestMapping("/post")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public Post addPost(@RequestParam Map<String,String> requestParams
    ) throws Exception {
        String strPost = requestParams.get("post");
        String email = requestParams.get("email");
        String name = requestParams.get("name");

        Post post = Post.builder()
                .name(name)
                .email(email)
                .post(strPost)
                .timeStamp(new Date().toString())
                .build();
        post = postService.addPost(post);
        return post;
    }

    @GetMapping
    public List<Post> getPost() {
        return postService.getPost();
    }
}
