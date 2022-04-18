package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.security.entities.AppRole;
import com.example.demo.security.entities.AppUser;

public class AppUserDetails implements UserDetails {
	private String userName;
	private String userPassword;
	private List<GrantedAuthority> authorities;
	
	public AppUserDetails(AppUser user) {
		System.out.println(user.getUsername()+"   "+user.getPassword());
		userName=user.getUsername();
		userPassword=user.getPassword();
		authorities = new ArrayList<>();
		for(AppRole role:user.getAppRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		for(GrantedAuthority auth:authorities) {
			System.out.println(auth);
		}
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return userPassword;
	}

	@Override
	public String getUsername() {
		
		return userName;
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

}
