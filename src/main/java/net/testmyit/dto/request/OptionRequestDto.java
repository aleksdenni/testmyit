package net.testmyit.dto.request;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Builder
@Value
@RequiredArgsConstructor
public class OptionRequestDto {

    @NonNull String option;
    @NonNull Boolean isCorrect;
}
