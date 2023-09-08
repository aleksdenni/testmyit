package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.UserDto;
import net.testmyit.dto.request.UserRequestDto;
import net.testmyit.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody @Valid UserRequestDto userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}