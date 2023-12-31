package net.testmyit.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class LogInRequestDto {

    @Email(regexp = "^(?=.{10,63}$)(?!.*\\s)"
            + "[a-zA-Z0-9!#$%&'*+\\-=?^_`{|}~]+"
            + "(?:[.\\-][a-zA-Z0-9!#$%&'*+\\-=?^_`{|}~]+)*"
            + "@[a-z0-9](?:[a-z0-9\\-]*[a-z0-9])*"
            + "(?:\\.[a-z0-9](?:[a-z0-9\\-]*[a-z0-9])*)+",
            message = "Email should be valid")
    @NonNull String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)"
            + "(?=.*[!\"#$%&'()*+,\\-./:;<=>?@[\\\\]^_{|}~])"
            + "[A-Za-z\\d!\"#$%&'()*+,\\-./:;<=>?@[\\\\]^_`{|}~]{8,32}$",
            message = "Password should be valid")
    @NonNull String password;
}