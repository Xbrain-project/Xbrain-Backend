package com.Xbrain.BackendXbrain.services;

import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.model.User;
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
    public User newUser(User newUser) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(newUser, userEntity);

        userRepository.save(userEntity);

        return newUser;
    }
}
