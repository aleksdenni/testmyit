package net.testmyit.service;

import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.OptionRequestDto;
import net.testmyit.dto.response.OptionResponseDto;
import net.testmyit.mapper.OptionMapper;
import net.testmyit.model.Option;
import net.testmyit.repository.OptionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionMapper optionMapper;
    private final OptionRepository optionRepository;

    @Transactional
    public OptionResponseDto createOption(OptionRequestDto optionRequestDto) {
        final Option option = optionMapper.toEntity(optionRequestDto);
        final Option savedOption = optionRepository.save(option);
        return optionMapper.toDto(savedOption);
    }

    @Transactional
    public OptionResponseDto getOption(Long id) {
        final Option option = optionRepository.findById(id).orElse(null);
        return option != null ? optionMapper.toDto(option) : null;
    }

    @Transactional
    public OptionResponseDto updateOption(Long id, OptionRequestDto optionRequestDto) {
        final Option option = optionMapper.toEntity(optionRequestDto);
        option.setId(id);
        final Option savedOption = optionRepository.save(option);
        return optionMapper.toDto(savedOption);
    }

    @Transactional
    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }
}
