package net.testmyit.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class RefreshTokenRequestDto {

    @JsonProperty("refresh_token")
    @NotBlank String refreshToken;

}
