package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.UserEntity;

import com.Xbrain.BackendXbrain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserEntity newUser(UserEntity newUser) {

        userRepository.save(newUser);

        return newUser;
    }

//    @Override
//    public ResponseEntity<Optional<UserEntity>> displayUserMetaData(Long userid) {
//        Optional<UserEntity> userEntity = userRepository.findById(userid);
//        return  ResponseEntity.ok(userEntity);

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return  userRepository.findById(id);
    }

}

