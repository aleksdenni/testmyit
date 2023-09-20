package net.testmyit.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.testmyit.configuration.KeycloakConfiguration;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.core.Response;

@Component
@RequiredArgsConstructor
@Slf4j
public class KeycloakAdmin {
    private final KeycloakConfiguration keycloakConfiguration;
    private final Keycloak keycloak;
    public void createUser(UserRepresentation userRepresentation){
        log.info("Creating user with username: {}", userRepresentation.getUsername());
        int statusCode;
        try (var response = keycloak.realm(keycloakConfiguration.getRealm())
                .users()
                .create(userRepresentation)) {
            statusCode = response.getStatus();
            if (statusCode == Response.Status.CREATED.getStatusCode()) {
                log.info("User created successfully with status code: {}", statusCode);
            } else {
                log.error("User creation failed with status code: {}", statusCode);
                throw new ResponseStatusException(HttpStatus.valueOf(statusCode));
            }
        }
    }
}