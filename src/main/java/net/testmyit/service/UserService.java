package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import net.testmyit.dto.UserDto;
import net.testmyit.dto.request.UserRequestDto;
import net.testmyit.mapper.UserMapper;
import net.testmyit.model.User;
import net.testmyit.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional
    public UserDto createUser(UserRequestDto userRequestDto) {
        final User user = userMapper.toUser(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}