package com.kit.movie.domain.review;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String postDate;

    @Column(nullable = false)
    private Integer likeCount;

    @Column(nullable = false)
    private Boolean grade;

    @Transient
    private Long userId, movieId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID", nullable = false)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Builder
    public Review(User user, Movie movie, String contents, String postDate, Boolean grade) {
        this.user = user;
        this.movie = movie;
        this.contents = contents;
        this.postDate = postDate;
        this.grade = grade;
    }
}
