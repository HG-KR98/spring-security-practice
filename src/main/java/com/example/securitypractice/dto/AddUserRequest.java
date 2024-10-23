package com.example.securitypractice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddUserRequest {
    private String email;
    private String password;
}
