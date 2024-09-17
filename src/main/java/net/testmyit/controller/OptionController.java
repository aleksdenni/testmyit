package net.testmyit.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.testmyit.dto.request.OptionRequestDto;
import net.testmyit.dto.response.OptionResponseDto;
import net.testmyit.service.OptionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/options")
@RequiredArgsConstructor
public class OptionController {
    private final OptionService optionService;

    @PostMapping
    public OptionResponseDto createOption(@RequestBody @Valid OptionRequestDto optionRequestDto) {
        return optionService.createOption(optionRequestDto);
    }

    @GetMapping("/id")
    public OptionResponseDto getOption(@PathVariable Long id) {
        return optionService.getOption(id);
    }

    @PutMapping("/id")
    public OptionResponseDto updateOption(@PathVariable Long id, @Valid @RequestBody OptionRequestDto optionRequestDto) {
        return optionService.updateOption(id, optionRequestDto);
    }

    @DeleteMapping("/id")
    public void deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
    }
}
