package com.kit.movie.domain.movie;

import com.kit.movie.domain.movie_actor.Movie_Actor;
import com.kit.movie.domain.review.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Double reservationRate;

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String imgUrl;

    @Builder
    public Movie(String name, Date releaseDate, String director, String genre, String imgUrl) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.director = director;
        this.genre = genre;
        this.imgUrl = imgUrl;
    }

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews = new ArrayList<>();
    public void setReviews(Review review) {
        this.reviews.add(review);
    }

    @OneToMany(mappedBy = "movie")
    private List<Movie_Actor> movie_actors = new ArrayList<>();

}
