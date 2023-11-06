package net.testmyit.mapper;

import net.testmyit.dto.request.UserRequestDto;
import net.testmyit.dto.response.UserResponseDto;
import net.testmyit.model.User;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {
    public User toEntity(UserRequestDto userRequestDto) {
        return User.builder()
                .email(userRequestDto.getEmail())
                .name(userRequestDto.getName())
                .build();
    }

    public User toEntity(UserResponseDto userResponseDto) {
        return User.builder()
                .email(userResponseDto.getEmail())
                .name(userResponseDto.getName())
                .build();
    }

    public UserResponseDto toResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public UserRepresentation toUserRepresentation(UserRequestDto userRequestDto) {
        final var credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(userRequestDto.getPassword());
        credential.setTemporary(false);
        final var userRepresentation = new UserRepresentation();
        userRepresentation.setEmail(userRequestDto.getEmail());
        userRepresentation.setCredentials(List.of(credential));
        return userRepresentation;
    }
}