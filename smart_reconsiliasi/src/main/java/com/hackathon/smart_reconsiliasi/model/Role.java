package com.example.mini_project.model;


public enum Role {
    SUPER_ADMIN,
    APPROVER,
    ADMINISTRASI;

    public String getAuthority() {
        return name();
    }
}

