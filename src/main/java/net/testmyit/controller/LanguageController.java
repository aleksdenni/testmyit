package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.LanguageRequestDto;
import net.testmyit.dto.response.LanguageResponseDto;
import net.testmyit.service.LanguageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/languages")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @PostMapping
    public LanguageResponseDto createLanguage(@RequestBody @Valid LanguageRequestDto languageRequestDto){
        return languageService.createLanguage(languageRequestDto);
    }

    @GetMapping("/id")
    public LanguageResponseDto getLanguage(@PathVariable Long id){
        return languageService.getLanguage(id);
    }

    @PutMapping("/id")
    public LanguageResponseDto updateLanguage(@PathVariable Long id, @Valid @RequestBody LanguageRequestDto languageRequestDto){
        return languageService.updateLanguage(id, languageRequestDto);
    }

    @DeleteMapping("/id")
    public void deleteLanguage(@PathVariable Long id){
        languageService.deleteLanguage(id);
    }
}
