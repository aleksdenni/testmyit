package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.testmyit.dto.request.LogInRequestDto;
import net.testmyit.dto.request.LogOutRequestDto;
import net.testmyit.dto.request.RefreshTokenRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.dto.response.RefreshTokenResponseDto;
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

    public Mono<String> logOut(LogOutRequestDto logOutRequest) {
        return keycloakAuth.logOut(logOutRequest);
    }

    public Mono<RefreshTokenResponseDto> refreshToken(RefreshTokenRequestDto refreshTokenRequest) {
        return keycloakAuth.refreshToken(refreshTokenRequest);
    }
}
