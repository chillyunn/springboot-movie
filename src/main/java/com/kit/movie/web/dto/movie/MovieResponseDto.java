package com.kit.movie.web.dto.movie;

import com.kit.movie.domain.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponseDto {
    private Long movieId;
    private String name, director, genre;
    private Double reservationRate;
    private String releaseDate;
    private String imgUrl;
    private Integer runtime,grade;
    private String actor;

    public MovieResponseDto(Movie entity) {
        this.movieId = entity.getMovieId();
        this.name = entity.getName();
        this.reservationRate = entity.getReservationRate();
        this.releaseDate = entity.getReleaseDate();
        this.director = entity.getDirector();
        this.genre = entity.getGenre();
        this.imgUrl=entity.getImgUrl();
        this.actor=entity.getActor();
        this.grade=entity.getGrade();
    }
}
