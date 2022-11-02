package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.UserEntity;

import java.util.Optional;


public interface UserService {
    UserEntity newUser(UserEntity newUser);


    Optional<UserEntity> getUserById(Long id);


//    ResponseEntity<Optional<UserEntity>> displayUserMetaData(Long userid);

}
