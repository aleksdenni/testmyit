package net.testmyit.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.testmyit.dto.request.UserRequestDto;
import net.testmyit.dto.response.UserResponseDto;
import net.testmyit.service.UserService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        final var userRequest = new UserRequestDto(0L, "name", "ababa@gmail.com", "1234");
        final var createdUser = new UserResponseDto(0L, "name", "ababa@gmail.com");

        when(userService.createUser(userRequest)).thenReturn(createdUser);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(userRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.equalTo(0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(userRequest.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", Matchers.equalTo(userRequest.getEmail())));

        verify(userService, times(1)).createUser(userRequest);
        verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUser() throws Exception {
        final var createdUser1 = new UserResponseDto(1L, "name1", "ababa1@gmail.com");

        when(userService.getUser(1L)).thenReturn(createdUser1);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", 1L))
                        .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userService, times(1)).getUser(createdUser1.getId());
        verifyNoMoreInteractions(userService);


    }

}
