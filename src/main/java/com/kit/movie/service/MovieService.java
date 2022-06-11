package com.kit.movie.service;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.movie.MovieRepository;
import com.kit.movie.web.dto.MovieSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional
    public Long save(MovieSaveRequestDto requestDto){
        return movieRepository.save(requestDto.toEntity()).getId();
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
