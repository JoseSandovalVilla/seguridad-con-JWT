package com.example.demo.controllers;

import com.example.demo.models.AuthenticationRequest;
import com.example.demo.models.AuthenticationResponse;
import com.example.demo.services.JwtUtil;
import com.example.demo.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        final String username = authenticationRequest.getUsername();
        final String password = authenticationRequest.getPassword();

        userDetailsService.authenticate(username, password);

        final String jwt = jwtUtil.generateToken(username);

        return new AuthenticationResponse(jwt);
    }
}
