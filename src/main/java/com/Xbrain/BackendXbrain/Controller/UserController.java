package com.Xbrain.BackendXbrain.Controller;


import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.exception.BaseException;
import com.Xbrain.BackendXbrain.services.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @PostMapping("/")
    public UserEntity addUser(@RequestBody UserEntity user) throws BaseException {


        return userService.create(user);
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







