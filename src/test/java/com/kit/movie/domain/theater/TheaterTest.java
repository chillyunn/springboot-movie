package com.kit.movie.domain.theater;

import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.screen.ScreenRepository;
import com.kit.movie.web.dto.screen.ScreenSaveRequestDto;
import com.kit.movie.web.dto.theater.TheaterSaveRequestDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class TheaterTest {

    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    ScreenRepository screenRepository;

    @AfterAll
    public void cleanup() {
        theaterRepository.deleteAll();
    }

    @Test
    void 영화관_등록(){
        //given
        String name = "구미영화관";

        TheaterSaveRequestDto requestDto = TheaterSaveRequestDto.builder()
                .name(name)
                .build();
        theaterRepository.save(requestDto.toEntity());
        //when
        List<Theater> theaters = theaterRepository.findAll();
        //then
        Theater theater = theaters.get(0);
        assertThat(theater.getName()).isEqualTo(name);
    }
    @Test
    void 상영관_등록(){
        //given
        String name= "1관";
        Integer floor = 1;
        Theater theater= theaterRepository.findByName("구미영화관");

        ScreenSaveRequestDto requestDto = ScreenSaveRequestDto.builder()
                .name(name)
                .floor(floor)
                .build();
        screenRepository.save(requestDto.toEntity(theater));
        //when
        List<Screen> screens = screenRepository.findAll();
        //then
        Screen screen = screens.get(0);
        assertThat(screen.getName()).isEqualTo(name);
        assertThat(screen.getFloor()).isEqualTo(floor);
        assertThat(screen.getTheater()).isEqualTo(theater);

        //assertThat(theater.getScreens().get(0).getName()).isEqualTo(name);

    }

}