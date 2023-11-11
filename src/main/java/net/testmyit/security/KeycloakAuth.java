package net.testmyit.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.testmyit.configuration.KeycloakConfiguration;
import net.testmyit.dto.request.LogOutRequestDto;
import net.testmyit.dto.request.RefreshTokenRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.dto.response.RefreshTokenResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static org.keycloak.OAuth2Constants.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class KeycloakAuth {
    private final KeycloakConfiguration keycloakConfiguration;
    private final WebClient webClient;
    @Value("${keycloak.tokenUri}")
    private String tokenUri;
    @Value("${keycloak.logoutUri}")
    private String logoutUri;
    @Value("${keycloak.userInfoUri}")
    private String userInfoUri;

    public Mono<LogInResponseDto> getAccessToken(String email, String password) {
        return webClient.post()
                .uri(tokenUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters
                        .fromFormData(GRANT_TYPE, PASSWORD)
                        .with(CLIENT_ID, keycloakConfiguration.getClientId())
                        .with(CLIENT_SECRET, keycloakConfiguration.getClientSecret())
                        .with(USERNAME, email)
                        .with(PASSWORD, password)
                        .with(SCOPE, SCOPE_OPENID))
                .retrieve()
                .bodyToMono(LogInResponseDto.class)
                .doOnSuccess(response -> log.info("successful authentication response"))
                .doOnError(error -> log.error("authenticate failed due to {}",
                        error.getMessage()));
    }

    public Mono<String> logOut(LogOutRequestDto requestDto) {
        return webClient.post()
                .uri(logoutUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters
                        .fromFormData(ID_TOKEN_HINT, requestDto.getIdToken()))
                .retrieve()
                .bodyToMono(String.class)
                .doOnSuccess(response -> log.info("logout success"))
                .doOnError(error -> {
                    log.error("logout failed due to {}", error.getMessage());
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "logout failed");
                });
    }

    public Mono<RefreshTokenResponseDto> refreshToken(RefreshTokenRequestDto refreshTokenRequest) {
        return webClient.post()
                .uri(tokenUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters
                        .fromFormData(GRANT_TYPE, REFRESH_TOKEN)
                        .with(CLIENT_ID, keycloakConfiguration.getClientId())
                        .with(CLIENT_SECRET, keycloakConfiguration.getClientSecret())
                        .with(REFRESH_TOKEN, refreshTokenRequest.getRefreshToken()))
                .retrieve()
                .bodyToMono(RefreshTokenResponseDto.class)
                .doOnSuccess(response -> log.info("token refresh success"))
                .doOnError(error -> log.error("logout failed due to {}", error.getMessage()));
    }
}