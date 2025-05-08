package com.hackathon.smart_reconsiliasi.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String username;

    public UserRequest(Long id, String username) {}

    public UserRequest(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

