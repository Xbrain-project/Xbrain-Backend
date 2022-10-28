package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.UserEntity;

import com.Xbrain.BackendXbrain.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
}
