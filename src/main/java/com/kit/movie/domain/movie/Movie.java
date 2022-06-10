package com.kit.movie.domain.movie;

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

    @Column
    private Double reservationRate;

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String genre;

    @Builder
    public Movie(String name, Date releaseDate, String director, String genre) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.director = director;
        this.genre = genre;
    }

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews = new ArrayList<>();
    public List<Review> getReviews() { return reviews; }
    public void setReviews(List<Review> reviews) { this.reviews = reviews; }

}
