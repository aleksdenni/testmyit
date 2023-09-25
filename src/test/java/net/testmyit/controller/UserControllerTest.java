package net.testmyit.controller;


import net.testmyit.dto.request.UserRequestDto;
import net.testmyit.dto.response.UserResponseDto;
import net.testmyit.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@ActiveProfiles("test")
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        UserRequestDto userRequest = new UserRequestDto("ababa@gmail.com", "1234");
        UserResponseDto createdUser = UserResponseDto.builder()
                .email("ababa@gmail.com")
                .build();

        when(userService.createUser(userRequest)).thenReturn(createdUser);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\": \"ababa@gmail.com\"," +
                                "    \"password\": \"1234\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(createdUser.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(createdUser.getName()));

        verify(userService, times(1)).createUser(userRequest);
        verifyNoMoreInteractions(userService);
    }


}
