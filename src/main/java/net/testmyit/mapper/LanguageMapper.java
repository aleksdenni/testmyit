package net.testmyit.mapper;


import net.testmyit.dto.LanguageDto;
import net.testmyit.dto.request.LanguageRequestDto;
import net.testmyit.dto.response.LanguageResponseDto;
import net.testmyit.model.Language;
import org.springframework.stereotype.Component;

@Component
public class LanguageMapper {

    public Language toEntity(LanguageRequestDto languageRequestDto){
        return Language.builder()
                .language(languageRequestDto.getLanguage())
                .image(languageRequestDto.getImage())
                .build();
    }

    public LanguageResponseDto toDto(Language language){
        return LanguageResponseDto.builder()
                .id(language.getId())
                .language(language.getLanguage())
                .image(language.getImage())
                .build();
    }

    public Language toEntity(LanguageResponseDto languageResponseDto) {
        return Language.builder()
                .id(languageResponseDto.getId())
                .language(languageResponseDto.getLanguage())
                .image(languageResponseDto.getImage())
                .build();
    }
}
