package com.Xbrain.BackendXbrain;

import com.Xbrain.BackendXbrain.dto.UserDTO;
import com.Xbrain.BackendXbrain.entity.UserEntity;
import com.Xbrain.BackendXbrain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class getAllUsers implements getUserStrategy {
    @Autowired
    private UserRepository userRepository ;

    @Override
    public List<UserEntity> getUser() {
        return userRepository.findAll();
    }



}
