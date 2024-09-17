package net.testmyit.mapper;

import net.testmyit.dto.request.QuestionRequestDto;
import net.testmyit.dto.response.QuestionResponseDto;
import net.testmyit.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionMapper {

    public Question toEntity(QuestionRequestDto questionRequestDto) {
        return Question.builder()
                .question(questionRequestDto.getQuestion())
                .category_id(questionRequestDto.getCategory_id())
                .build();
    }

    public Question toEntity(QuestionResponseDto questionResponseDto) {
        return Question.builder()
                .id(questionResponseDto.getId())
                .question(questionResponseDto.getQuestion())
                .category_id(questionResponseDto.getCategory_id())
                .build();
    }

    public QuestionResponseDto toDto(Question question) {
        return QuestionResponseDto.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .category_id(question.getCategory_id())
                .build();
    }
}
