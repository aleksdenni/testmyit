package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import net.testmyit.dto.LanguageDto;
import net.testmyit.dto.request.LanguageRequestDto;
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
    public LanguageDto createLanguage(LanguageRequestDto languageRequestDto) {
        final Language language = languageMapper.toLanguage(languageRequestDto);
        Language savedLanguage = languageRepository.save(language);
        return languageMapper.toDto(savedLanguage);
    }

    @Transactional
    public LanguageDto getLanguage(Long id){
        Language language = languageRepository.findById(id).orElse(null);
        return language != null ? languageMapper.toDto(language) : null;
    }

    @Transactional
    public LanguageDto updateLanguage(Long id, LanguageDto languageDto) {
        final Language language = languageMapper.toLanguage(languageDto);
        language.setId(id);
        final Language savedLanguage = languageRepository.save(language);
        return languageMapper.toDto(savedLanguage);
    }

    @Transactional
    public void deleteLanguage(Long id){
        languageRepository.deleteById(id);
    }
}