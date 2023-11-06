package net.testmyit.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;;
import net.testmyit.dto.request.LogOutRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Function;

import static org.keycloak.OAuth2Constants.*;


@Component
@RequiredArgsConstructor
@Slf4j
public class KeycloakAuth {
    private final WebClient webClient;
    @Value("${keycloak.tokenUri}")
    private String tokenUri;
    @Value("${keycloak.logoutUri}")
    private String logoutUri;

    public Mono<LogInResponseDto> getAccessToken(String email, String password) {
        return webClient.post()
                .uri(tokenUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(USERNAME, email)
                        .with(PASSWORD, password)
                        .with(GRANT_TYPE, PASSWORD))
                .retrieve()
                .bodyToMono(LogInResponseDto.class)
                .doOnSuccess(
                        response -> log.info("successful authentication response"))
                .doOnError(error -> log.error("authenticate failed due to {}",
                        error.getMessage()));
    }

    public void logOut(LogOutRequestDto requestDto) {
        webClient.get()
                .uri(logoutUri)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + requestDto.getAccessToken())
                .retrieve()
                .toBodilessEntity()
                .doOnSuccess(response -> log.info("logout success"))
                .doOnError(error -> {
                    log.error("logout failed due to {}", error.getMessage());
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "logout failed");
                });
    }
}