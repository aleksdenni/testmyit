package net.testmyit.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class UserDto {

    Long id;
    @NonNull String name;
    @NonNull String email;
}
