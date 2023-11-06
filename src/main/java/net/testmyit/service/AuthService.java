package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.testmyit.dto.request.LogInRequestDto;
import net.testmyit.dto.request.LogOutRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.security.KeycloakAuth;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final KeycloakAuth keycloakAuth;

    public Mono<LogInResponseDto> logIn(LogInRequestDto logInRequest) {
        Mono<LogInResponseDto> responseDto = keycloakAuth.getAccessToken(logInRequest.getEmail(), logInRequest.getPassword());
        log.info("Access token generated successfully for email: {}", logInRequest.getEmail());
        return responseDto;
    }

    public void logOut(LogOutRequestDto requestDto) {
        keycloakAuth.logOut(requestDto);
    }
}
