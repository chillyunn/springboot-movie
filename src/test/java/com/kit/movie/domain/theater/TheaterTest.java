package com.kit.movie.domain.theater;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TheaterTest {

    @Autowired
    TheaterRepository theaterRepository;
    @Test
    void 영화관_등록(){
        //given
        String name = "구미영화관";

        theaterRepository.save(Theater.builder()
                .name(name)
                .build());

        //when
        List<Theater> theaters = theaterRepository.findAll();

        //then

        Theater theater = theaters.get(0);
        assertThat(theater.getName()).isEqualTo(name);
    }

}