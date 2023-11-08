package net.testmyit.dto.response;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.testmyit.model.Category;

@Value
@Builder
@RequiredArgsConstructor
public class QuestionResponseDto {
    @NonNull Long id;
    @NonNull String question;
    @NonNull Category category_id;
}
