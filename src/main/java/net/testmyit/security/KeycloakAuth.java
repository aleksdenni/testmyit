package net.testmyit.security;

import lombok.RequiredArgsConstructor;
import net.testmyit.dto.response.LogInResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import static org.keycloak.OAuth2Constants.*;

@Component
@RequiredArgsConstructor
public class KeycloakAuth {
    private final WebClient webClient;
    private final @Value("keycloak.tokenUri") String tokenUri;

    public LogInResponseDto getAccessToken(String email, String password) {
        return webClient.post()
                .uri(tokenUri)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(USERNAME, email)
                        .with(PASSWORD, password)
                        .with(GRANT_TYPE, PASSWORD))
                .retrieve()
                .bodyToMono(LogInResponseDto.class)
                .block();
    }
}