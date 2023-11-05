package net.testmyit.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;;
import net.testmyit.dto.response.LogInResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.keycloak.OAuth2Constants.*;


@Component
@RequiredArgsConstructor
@Slf4j
public class KeycloakAuth {
    private final WebClient webClient;
    @Value("${keycloak.tokenUri}")
    private String tokenUri;

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
}