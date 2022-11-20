package com.Xbrain.XbrainBackend.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Xbrain.XbrainBackend.model.Role;
import com.Xbrain.XbrainBackend.model.User;

public class CustomUserDetails implements UserDetails{
    private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Role> roles = user.getRoles();
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public String getFullName() {
		return this.user.getFirstName() + " " + this.user.getLastName();
	}
	public void setFirstName(String firstName) {
		this.user.setFirstName(firstName);
	}
	public void setLastName(String lastName) {
		this.user.setLastName(lastName);
	}
	public String getFirstName() {
		return this.user.getFirstName();
	}

	public String getLastName() {
		return this.user.getLastName();
	}

}
