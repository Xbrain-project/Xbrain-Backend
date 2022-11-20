package com.Xbrain.XbrainBackend.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Xbrain.XbrainBackend.model.Role;
import com.Xbrain.XbrainBackend.model.User;
import com.Xbrain.XbrainBackend.repository.UserRepository;
import com.Xbrain.XbrainBackend.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
	private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save1(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role("ROLE_Teacher")),null,null,null,null);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
        System.out.println(mapRolesToAuthorities(user.getRoles()));
        System.out.println(user.getEmail());
		return new CustomUserDetails(user);		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

    @Override
    public User save2(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getEmail(), passwordEncoder.encode(registrationDto.getPassword()),Arrays.asList(new Role("ROLE_Student")),null,null,null,null);
        return userRepository.save(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateDetails(User user) {
        return userRepository.save(user);
    } 
}
