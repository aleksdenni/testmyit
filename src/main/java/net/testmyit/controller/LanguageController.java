package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.LanguageDto;
import net.testmyit.dto.request.LanguageRequestDto;
import net.testmyit.service.LanguageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/languages")
@RequiredArgsConstructor
public class LanguageController {
    private final LanguageService languageService;

    @PostMapping
    public LanguageDto createLanguage(@RequestBody @Valid LanguageRequestDto languageRequestDto){
        return languageService.createLanguage(languageRequestDto);
    }

    @GetMapping("/id")
    public LanguageDto getLanguage(@PathVariable Long id){
        return languageService.getLanguage(id);
    }

    @PutMapping("/id")
    public LanguageDto updateLanguage(@PathVariable Long id, @RequestBody LanguageDto languageDto){
        return languageService.updateLanguage(id, languageDto);
    }

    @DeleteMapping("/id")
    public void deleteLanguage(@PathVariable Long id){
        languageService.deleteLanguage(id);
    }
}
