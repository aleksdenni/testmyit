package net.testmyit.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class LogInResponseDto {

    @JsonProperty("access_token")
    String accessToken;

    @JsonProperty("refresh_token")
    String refreshToken;

}