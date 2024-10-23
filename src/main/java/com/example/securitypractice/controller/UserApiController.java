package com.example.securitypractice.controller;

import com.example.securitypractice.dto.AddUserRequest;
import com.example.securitypractice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@Tag(name = "회원 API", description = "회원 가입 / 로그인 / 로그아웃")
public class UserApiController {

    private final UserService userService;

    @Operation(summary = "회원가입", description = "유저 회원가입 API")
    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request);
        return "save request!";
    }

    @Operation(summary = "로그아웃", description = "유저 로그아웃 API")
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "logout!";
    }



}
