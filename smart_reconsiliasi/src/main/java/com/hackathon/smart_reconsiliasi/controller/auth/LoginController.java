package com.hackathon.smart_reconsiliasi.controller.auth;

import com.hackathon.smart_reconsiliasi.dto.auth.LoginRequest;
import com.hackathon.smart_reconsiliasi.dto.auth.LoginResponse;
import com.hackathon.smart_reconsiliasi.service.auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mini_project/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}

