package com.Xbrain.BackendXbrain.Controller;




import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {

        this.postService = postService;
    }

    @PostMapping("/{userId}/")
    public ResponseEntity<Optional<Object>> addPost(@PathVariable(value = "userId") Long userId, @RequestBody PostEntity postEntity)  {
        ResponseEntity<Optional<Object>> response =postService.addPost(userId,postEntity);

        return response;
    }

    @GetMapping("/")
    public List<PostEntity> getAllPosts() {



//        if (title == null)
//            PostRepository.findAll().forEach(tutorials::add);
//        else
//            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
//
//        if (tutorials.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }

        return postService.getAllPosts();
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<String> getPostById(@PathVariable String id) {
//        String response = postService.getPostById(id);
//        return ResponseEntity.ok(response);
//    }

//    @PostMapping("/upload-profile")
//    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
//        String response = business.uploadProfilePicture(file);
//        return ResponseEntity.ok(response);
//    }


}







