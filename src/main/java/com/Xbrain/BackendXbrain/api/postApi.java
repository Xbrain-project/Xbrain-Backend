package com.Xbrain.BackendXbrain.api;


import com.Xbrain.BackendXbrain.bussiness.PostBusiness;
import com.Xbrain.BackendXbrain.bussiness.TestBussiness;
import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/post")
public class postApi {

    private final PostBusiness postBusiness;

    public postApi(PostBusiness postBusiness) {

        this.postBusiness = postBusiness;
    }

    @PostMapping("/")
    public ResponseEntity<PostEntity> addPost(@RequestBody PostEntity postEntity) throws BaseException {
        PostEntity response = postBusiness.addPost(postEntity);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getPostById(@PathVariable String id) {
        String response = postBusiness.getPostById(id);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/upload-profile")
//    public ResponseEntity<String> uploadProfilePicture(@RequestPart MultipartFile file) throws BaseException {
//        String response = business.uploadProfilePicture(file);
//        return ResponseEntity.ok(response);
//    }


}







