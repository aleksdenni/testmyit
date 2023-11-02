package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.OptionRequestDto;
import net.testmyit.dto.request.QuestionRequestDto;
import net.testmyit.dto.response.QuestionResponseDto;
import net.testmyit.service.QuestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public QuestionResponseDto createQuestion(@RequestBody @Valid QuestionRequestDto questionRequestDto) {
        return questionService.createQuestion(questionRequestDto);
    }

    @GetMapping("/id")
    public QuestionResponseDto getQuestion(@PathVariable Long id) {
        return questionService.getQuestion(id);
    }

    @PutMapping("/id")
    public QuestionResponseDto updateQuestion(@PathVariable Long id, @Valid @RequestBody QuestionRequestDto questionRequestDto) {
        return questionService.updateQuestion(id, questionRequestDto);
    }

    @DeleteMapping("/id")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}
