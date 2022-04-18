package com.example.demo.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.security.entities.AppUser;
import com.example.demo.security.repositories.AppUserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{
	@Autowired
	AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser= appUserRepository.findByUsername(username);
		/*List<GrantedAuthority> list=new ArrayList<>();
		list.add(new SimpleGrantedAuthority("ADMIN"));
		User user =new User(username, username, list);*/
		return new AppUserDetails(appUser);
	}

}
