package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.UserRequestDto;
import net.testmyit.dto.response.UserResponseDto;
import net.testmyit.mapper.UserMapper;
import net.testmyit.model.User;
import net.testmyit.repository.UserRepository;
import net.testmyit.security.KeycloakAdmin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final KeycloakAdmin keycloakAdmin;

    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        final var userRepresentation = userMapper.toUserRepresentation(userRequestDto);
        keycloakAdmin.createUser(userRepresentation);
        final User user = userMapper.toEntity(userRequestDto);
        final User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Transactional
    public UserResponseDto getUser(Long id) {
        final User user = userRepository.findById(id).orElse(null);
        return user != null ? userMapper.toResponseDto(user) : null;
    }
    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        final User user = userMapper.toEntity(userRequestDto);
        user.setId(id);
        final User savedUser = userRepository.save(user);
        return userMapper.toResponseDto(savedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}