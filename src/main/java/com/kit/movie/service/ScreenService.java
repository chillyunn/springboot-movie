package com.kit.movie.service;

import com.kit.movie.domain.screen.ScreenRepository;
import com.kit.movie.web.dto.ScreenSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ScreenService {
    private final TheaterService theaterService;
    private final ScreenRepository screenRepository;

    @Transactional
    public Long save(ScreenSaveRequestDto requestDto){
        return screenRepository.save(requestDto.toEntity(theaterService.findByName(requestDto.getTheaterName()))).getId();
    }
}
