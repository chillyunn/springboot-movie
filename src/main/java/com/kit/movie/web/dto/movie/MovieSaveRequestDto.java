package com.kit.movie.web.dto.movie;

import com.kit.movie.domain.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MovieSaveRequestDto {
    private String name, director,releaseDate,genre,imgUrl,actor;
    private Integer grade,runtime;

    public MovieSaveRequestDto(String name, String director, String releaseDate, String genre, String imgUrl, Integer grade, Integer runtime,String actor) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.imgUrl = imgUrl;
        this.grade = grade;
        this.runtime = runtime;
        this.actor=actor;
    }

    @Builder
    public Movie toEntity(){
        return Movie.builder()
                .name(name)
                .director(director)
                .releaseDate(releaseDate)
                .genre(genre)
                .imgUrl(imgUrl)
                .grade(grade)
                .runtime(runtime)
                .actor(actor)
                .build();
    }
}

