package com.kit.movie.web.dto.timetable;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.timetable.Timetable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimetableResponseDto {
    private String time;
    private Screen screen;
    private Movie movie;

    public TimetableResponseDto(Timetable entity) {
        this.time = entity.getTime();
        this.screen = entity.getScreen();
        this.movie = entity.getMovie();
    }
}
