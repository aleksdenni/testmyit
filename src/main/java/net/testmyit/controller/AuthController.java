package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.LogInRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LogInResponseDto logIn(@Valid @RequestBody LogInRequestDto logInRequest) {
        return authService.logIn(logInRequest);
    }

}