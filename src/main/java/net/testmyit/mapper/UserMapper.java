package net.testmyit.mapper;

import net.testmyit.dto.UserDto;
import net.testmyit.dto.request.UserRequestDto;
import net.testmyit.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserRequestDto userRequestDto) {
        return User.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .build();
    }

    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}