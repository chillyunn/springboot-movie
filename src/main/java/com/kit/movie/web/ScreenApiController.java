package com.kit.movie.web;

import com.kit.movie.service.ScreenService;
import com.kit.movie.web.dto.screen.ScreenSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScreenApiController {
    private final ScreenService screenService;

    @PostMapping("/api/screens")
    public Long save(@RequestBody ScreenSaveRequestDto requestDto){
        return screenService.save(requestDto);
    }
}
