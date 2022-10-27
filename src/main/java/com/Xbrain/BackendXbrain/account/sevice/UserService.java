package com.Xbrain.Xbrain.account.sevice;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.Xbrain.Xbrain.account.model.User;
import com.Xbrain.Xbrain.account.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
