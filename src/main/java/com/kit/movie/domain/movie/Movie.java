package com.kit.movie.domain.movie;

import com.kit.movie.domain.movie_actor.Movie_Actor;
import com.kit.movie.domain.review.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer grade;

    @Column(nullable = true)
    private Integer reservated;

    @Column(nullable = false)
    private Integer runtime;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String imgUrl;

    @Column(nullable = false)
    private String actor;

    @Builder
    public Movie(String name, Integer grade, Integer runtime, String releaseDate, String director, String genre, String imgUrl,String actor) {
        this.name = name;
        this.grade = grade;
        this.runtime = runtime;
        this.releaseDate = releaseDate;
        this.director = director;
        this.genre = genre;
        this.imgUrl = imgUrl;
        this.actor=actor;
    }

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews = new ArrayList<>();

    public void setReviews(Review review) {
        this.reviews.add(review);
    }

    @OneToMany(mappedBy = "movie")
    private List<Movie_Actor> movie_actors = new ArrayList<>();
}
