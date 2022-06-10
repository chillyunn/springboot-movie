package com.kit.movie.web.dto;

import com.kit.movie.domain.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Getter
@NoArgsConstructor
public class MovieSaveRequestDto {
    private String name, director;
    private Date releaseDate;
    private String genre;

    @Builder
    public MovieSaveRequestDto(String name, String director, Date releaseDate, String genre) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public Movie toEntity(){
        return Movie.builder()
                .name(name)
                .director(director)
                .releaseDate(releaseDate)
                .genre(genre)
                .build();
    }
}

