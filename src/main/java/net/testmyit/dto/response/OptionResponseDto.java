package net.testmyit.dto.response;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class OptionResponseDto {

    Long id;
    @NonNull String option;
    @NonNull Boolean isCorrect;

}
