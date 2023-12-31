package net.testmyit.dto.request;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Builder
@Value
@RequiredArgsConstructor
public class UserRequestDto {

    String name;
    @NonNull String email;
    @NonNull String password;
}
