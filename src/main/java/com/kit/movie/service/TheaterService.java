package com.kit.movie.service;

import com.kit.movie.domain.theater.Theater;
import com.kit.movie.domain.theater.TheaterRepository;
import com.kit.movie.web.dto.theater.TheaterSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    @Transactional
    public Long save(TheaterSaveRequestDto requestDto){
        return theaterRepository.save(requestDto.toEntity()).getId();
    }

    public Theater findByName(String name){
        return theaterRepository.findByName(name);
    }
}
