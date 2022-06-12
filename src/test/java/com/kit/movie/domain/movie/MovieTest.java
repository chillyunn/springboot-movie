package com.kit.movie.domain.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;



import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class MovieTest {
    @Autowired
    MovieRepository movieRepository;

    @Test
    void 페이징_테스트() {
        Pageable firstPage = PageRequest.of(0, 3);
        Page<Movie> movies = movieRepository.findAll(firstPage);
    }
}