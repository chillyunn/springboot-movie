package com.kit.movie.service;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.movie.MovieRepository;
import com.kit.movie.web.dto.movie.MovieSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional
    public Long save(MovieSaveRequestDto requestDto) {
        return movieRepository.save(requestDto.toEntity()).getMovieId();
    }

    @Transactional
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Transactional
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Transactional
    public Movie findById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Movie"));
    }
}
