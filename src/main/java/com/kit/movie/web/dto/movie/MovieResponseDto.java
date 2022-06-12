package com.kit.movie.web.dto.movie;

import com.kit.movie.domain.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MovieResponseDto {
    private Integer recommend;
    private Long movieId;
    private String name, director, genre;
    private Integer reservated;
    private String releaseDate;
    private String imgUrl;
    private Integer runtime,grade;
    private String actor;

    public MovieResponseDto(Movie entity) {
        this.movieId = entity.getMovieId();
        this.name = entity.getName();
        this.reservated = entity.getReservated();
        this.recommend = entity.getRecommend();
        this.releaseDate = entity.getReleaseDate();
        this.director = entity.getDirector();
        this.genre = entity.getGenre();
        this.imgUrl=entity.getImgUrl();
        this.actor=entity.getActor();
        this.grade=entity.getGrade();
    }
}
