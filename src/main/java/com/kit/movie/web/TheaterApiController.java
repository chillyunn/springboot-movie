package com.kit.movie.web;

import com.kit.movie.service.TheaterService;
import com.kit.movie.web.dto.theater.TheaterSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TheaterApiController {
    private final TheaterService theaterService;

    @PostMapping("/api/theaters")
    public Long save(@RequestBody TheaterSaveRequestDto requestDto){
        return theaterService.save(requestDto);
    }
}
