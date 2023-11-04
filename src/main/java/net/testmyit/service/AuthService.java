package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.testmyit.dto.request.LogInRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.security.KeycloakAuth;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final KeycloakAuth keycloakAuth;

    public LogInResponseDto logIn(LogInRequestDto logInRequest) {
        try {
            log.info("Generating login response for email: {}", logInRequest.getEmail());
            LogInResponseDto responseDto = keycloakAuth.getAccessToken(logInRequest.getEmail(), logInRequest.getPassword());
            log.info("Access token generated successfully for email: {}", logInRequest.getEmail());
            return responseDto;
        } catch (Exception e) {
            log.error("Error occurred while generating login response for email: {}", logInRequest.getEmail(), e);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials", e);
        }
    }

}
