package net.testmyit.mapper;

import net.testmyit.dto.request.OptionRequestDto;
import net.testmyit.dto.response.OptionResponseDto;
import net.testmyit.model.Option;
import org.springframework.stereotype.Component;

@Component
public class OptionMapper {

    public Option toEntity(OptionRequestDto optionRequestDto) {
        return Option.builder()
                .option(optionRequestDto.getOption())
                .isCorrect(optionRequestDto.getIsCorrect())
                .build();
    }

    public OptionResponseDto toDto(Option option){
        return OptionResponseDto.builder()
                .id(option.getId())
                .option(option.getOption())
                .isCorrect(option.getIsCorrect())
                .build();
    }

    public Option toEntity(OptionResponseDto optionResponseDto) {
        return Option.builder()
                .id(optionResponseDto.getId())
                .option(optionResponseDto.getOption())
                .isCorrect(optionResponseDto.getIsCorrect())
                .build();
    }
}
