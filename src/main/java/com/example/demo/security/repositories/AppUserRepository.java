package com.example.demo.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.security.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
