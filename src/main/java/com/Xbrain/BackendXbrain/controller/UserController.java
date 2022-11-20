package com.Xbrain.BackendXbrain.controller;


import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.exception.BaseException;
import com.Xbrain.BackendXbrain.services.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {

        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/users")
    public UserEntity addUser(@RequestBody UserEntity user) throws BaseException {


        return userServiceImpl.create(user);
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







