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
    private String name, director;
    private String releaseDate;
    private String genre;
    private String imgUrl;

    @Builder
    public MovieSaveRequestDto(String name, String director, String releaseDate, String genre, String imgUrl) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.imgUrl = imgUrl;
    }

    public Movie toEntity(){
        return Movie.builder()
                .name(name)
                .director(director)
                .releaseDate(releaseDate)
                .genre(genre)
                .imgUrl(imgUrl)
                .build();
    }
}

