package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.QuestionRequestDto;
import net.testmyit.dto.response.QuestionResponseDto;
import net.testmyit.mapper.QuestionMapper;
import net.testmyit.model.Question;
import net.testmyit.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    @Transactional
    public QuestionResponseDto createQuestion(QuestionRequestDto questionRequestDto) {
        final Question question = questionMapper.toEntity(questionRequestDto);
        final Question savedQuestion = questionRepository.save(question);
        return questionMapper.toDto(savedQuestion);
    }

    @Transactional
    public QuestionResponseDto getQuestion(Long id) {
        final Question question = questionRepository.findById(id).orElse(null);
        return question != null ? questionMapper.toDto(question) : null;
    }

    @Transactional
    public QuestionResponseDto updateQuestion(Long id, QuestionRequestDto questionRequestDto) {
        final Question question = questionMapper.toEntity(questionRequestDto);
        question.setId(id);
        final Question savedQuestion = questionRepository.save(question);
        return questionMapper.toDto(savedQuestion);
    }

    @Transactional
    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }
}

