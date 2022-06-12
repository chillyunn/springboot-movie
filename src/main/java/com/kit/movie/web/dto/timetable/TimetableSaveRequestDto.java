package com.kit.movie.web.dto.timetable;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.timetable.Timetable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class TimetableSaveRequestDto {
    private String time;
    private Integer price;
    private Long screenId;
    private Long movieId;
    private Integer percentDiscount;
    private Integer flatDiscount;

    @Builder
    public TimetableSaveRequestDto(String time, Integer price) {
        this.time = time;
        this.price = price;
    }
    public Timetable toEntity(Screen screen, Movie movie){
        return Timetable.builder()
                .time(time)
                .price(price)
                .screen(screen)
                .movie(movie)
                .build();
    }
}
