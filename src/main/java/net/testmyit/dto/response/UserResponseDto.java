package net.testmyit.dto.response;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class UserResponseDto {

    Long id;
    String name;
    @NonNull String email;
}