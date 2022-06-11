package com.kit.movie.web.dto;

import com.kit.movie.domain.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class MovieResponseDto {
    private Long id;
    private String name, director, genre;
    private Double reservationRate;
    private String releaseDate;
    private String imgUrl;

    public MovieResponseDto(Movie entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.reservationRate = entity.getReservationRate();
        this.releaseDate = entity.getReleaseDate();
        this.director = entity.getDirector();
        this.genre = entity.getGenre();
        this.imgUrl=entity.getImgUrl();
    }

}
