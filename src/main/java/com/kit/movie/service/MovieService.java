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
        return movieRepository.save(requestDto.toEntity()).getMovieId();
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 Movie"));
    }
}
