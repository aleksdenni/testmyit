package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.LogInRequestDto;
import net.testmyit.dto.request.LogOutRequestDto;
import net.testmyit.dto.request.RefreshTokenRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.dto.response.RefreshTokenResponseDto;
import net.testmyit.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public Mono<LogInResponseDto> logIn(@Valid @RequestBody LogInRequestDto logInRequest) {
        return authService.logIn(logInRequest);
    }

    @PostMapping("/logout")
    public Mono<String> logOut(@RequestBody @Valid LogOutRequestDto requestDto) {
        return authService.logOut(requestDto);
    }

    @PostMapping("/refresh")
    public Mono<RefreshTokenResponseDto> refreshToken(@RequestBody @Valid RefreshTokenRequestDto refreshTokenRequestDto) {
        return authService.refreshToken(refreshTokenRequestDto);
    }

}