package net.testmyit.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Value("${keycloak.authServerUrl}")
    private String authServerUrl;

    @Bean
    public WebClient keycloakWebClient() {
        return WebClient.builder()
                .baseUrl(authServerUrl)
                .build();
    }

}
