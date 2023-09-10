package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import net.testmyit.dto.LanguageDto;
import net.testmyit.dto.request.LanguageRequestDto;
import net.testmyit.dto.response.LanguageResponseDto;
import net.testmyit.mapper.LanguageMapper;
import net.testmyit.model.Language;
import net.testmyit.repository.LanguageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageMapper languageMapper;
    private final LanguageRepository languageRepository;

    @Transactional
    public LanguageResponseDto createLanguage(LanguageRequestDto languageRequestDto) {
        final Language language = languageMapper.toEntity(languageRequestDto);
        final Language savedLanguage = languageRepository.save(language);
        return languageMapper.toDto(savedLanguage);
    }

    @Transactional
    public LanguageResponseDto getLanguage(Long id){
        final Language language = languageRepository.findById(id).orElse(null);
        return language != null ? languageMapper.toDto(language) : null;
    }

    @Transactional
    public LanguageResponseDto updateLanguage(Long id, LanguageRequestDto languageRequestDto) {
        final Language language = languageMapper.toEntity(languageRequestDto);
        language.setId(id);
        final Language savedLanguage = languageRepository.save(language);
        return languageMapper.toDto(savedLanguage);
    }

    @Transactional
    public void deleteLanguage(Long id){
        languageRepository.deleteById(id);
    }
}
