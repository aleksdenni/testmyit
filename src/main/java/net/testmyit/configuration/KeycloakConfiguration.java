package net.testmyit.configuration;

import lombok.Getter;
import lombok.Setter;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.keycloak.OAuth2Constants.CLIENT_CREDENTIALS;

@Getter
@Setter
@ConfigurationProperties(prefix = "keycloak")
@Configuration
public class KeycloakConfiguration {
    private String authServerUri;
    private String realm;
    private String clientId;
    private String clientSecret;
    private String tokenUri;

    @Bean
    public Keycloak keycloak(){
        return KeycloakBuilder.builder()
                .serverUrl(authServerUri)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType(CLIENT_CREDENTIALS)
                .build();
    }
}