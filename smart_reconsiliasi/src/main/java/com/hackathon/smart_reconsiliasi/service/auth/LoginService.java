package com.hackathon.smart_reconsiliasi.service.auth;

import com.example.mini_project.security.JwtTokenProvider;
import com.hackathon.smart_reconsiliasi.dto.auth.LoginRequest;
import com.hackathon.smart_reconsiliasi.dto.auth.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        LoginResponse data = new LoginResponse();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        String token = jwtTokenProvider.generateToken(authentication);

        data.setRole(authentication.getAuthorities().iterator().next().getAuthority());
        data.setUsername(loginRequest.getUsername());
        data.setToken(token);


        return data;
    }
}

