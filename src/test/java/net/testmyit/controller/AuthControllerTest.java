package net.testmyit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.testmyit.dto.request.LogInRequestDto;
import net.testmyit.dto.response.LogInResponseDto;
import net.testmyit.service.AuthService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {
    @Autowired
    private AuthController authController;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private AuthService authService;

    @Test
    void testLogIn() throws Exception {
        LogInRequestDto logInRequest = new LogInRequestDto("alex.test@test.org", "pa55Word");

        LogInResponseDto logInResponseDto = LogInResponseDto.builder()
                .accessToken("access_token")
                .refreshToken("refresh_token")
                .idToken("id_token")
                .build();

        Mono<LogInResponseDto> logInResponse = Mono.just(logInResponseDto);

        Mockito.when(authController.logIn(logInRequest)).thenReturn(logInResponse);
        mockMvc.perform(post("/api/v1/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(logInRequest)))
                .andExpect(status().isOk());
    }

    @Test
    void testLogOut() throws Exception {

    }

    @Test
    void testRefreshToken() throws Exception {

    }
}

