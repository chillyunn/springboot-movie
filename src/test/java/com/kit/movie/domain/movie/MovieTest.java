package com.kit.movie.domain.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        Pageable secondPage = PageRequest.of(1,3);
        Page<Movie> movies = movieRepository.findAll(firstPage);
        movies.stream().forEach(m-> System.out.println("m.getName() = " + m.getName()));
        Page<Movie> movies2 = movieRepository.findAll(secondPage);
        movies2.stream().forEach(m-> System.out.println("m.getName() = " + m.getName()));
    }

    @Test
    void 예매율순_정렬_테스트(){
        Sort sort1 = Sort.by("reservationRate").descending();
        PageRequest pageRequest = PageRequest.of(0,11,sort1);
        Page<Movie> pageBy = movieRepository.findAll(pageRequest);
        pageBy.stream().forEach(m-> System.out.println("m.getName() = " + m.getName()));
    }

//    @Test
//    void 평점순_정렬_테스트(){
//        Sort sort2 = Sort.by("")
//    }


}