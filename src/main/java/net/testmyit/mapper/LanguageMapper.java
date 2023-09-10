package net.testmyit.mapper;


import net.testmyit.dto.LanguageDto;
import net.testmyit.dto.request.LanguageRequestDto;
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

    public LanguageDto toDto(Language language){
        return LanguageDto.builder()
                .id(language.getId())
                .language(language.getLanguage())
                .image(language.getImage())
                .build();
    }

    public Language toEntity(LanguageDto languageDto) {
        return Language.builder()
                .id(languageDto.getId())
                .language(languageDto.getLanguage())
                .image(languageDto.getImage())
                .build();
    }
}
