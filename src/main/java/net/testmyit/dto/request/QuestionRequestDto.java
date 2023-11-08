package net.testmyit.dto.request;

import lombok.Builder;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import net.testmyit.model.Category;

@Builder
@Value
@RequiredArgsConstructor
public class QuestionRequestDto {
    @NonNull String question;
    @NonNull Category category_id;
}
