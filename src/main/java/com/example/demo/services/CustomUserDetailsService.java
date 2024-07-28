package com.example.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user from database or other source
        // Example:
        return new org.springframework.security.core.userdetails.User(username, "password", new ArrayList<>());
    }

    public void authenticate(String username, String password) throws Exception {
        // Implement your own authentication logic here
    }
}
