package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.PostEntity;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity user){

        return userRepository.save(user);
    }

    // Factory
//    @Override
//    public List getData() {
//        List<UserEntity> users = new ArrayList<UserEntity>();
//
//        userRepository.findAll().forEach(users::add);
//
//
//        return users;
//    }
}
