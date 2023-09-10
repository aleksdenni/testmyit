package net.testmyit.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class LanguageDto {
    Long id;
    @NonNull String image;
    @NonNull String language;
}
