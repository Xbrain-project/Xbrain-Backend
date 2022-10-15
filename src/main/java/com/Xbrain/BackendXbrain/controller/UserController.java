package com.Xbrain.BackendXbrain.controller;

import com.Xbrain.BackendXbrain.model.User;
import com.Xbrain.BackendXbrain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {


    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User newUser(@RequestBody User newUser){
        return userService.newUser(newUser);
    }

//    @GetMapping("/users")
//    List<User> getAllUsers(){
//        return  userRepository.findAll();
//    }

//    @GetMapping("/user/{id}")
//    User getUserById(@PathVariable Long id){
//        return userRepo.findById(id)
//                .orElseThrow(()->new UserNotFoundException(id));
//    }
}
