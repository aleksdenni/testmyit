package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.LogInRequestDto;
import net.testmyit.dto.request.LogOutRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logOut(@RequestBody @Valid LogOutRequestDto requestDto) {
        authService.logOut(requestDto);
    }

}