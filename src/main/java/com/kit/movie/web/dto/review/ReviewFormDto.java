package com.kit.movie.web.dto.review;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.review.Review;
import com.kit.movie.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewFormDto {
    private User user;
    private Movie movie;
    private Long userId, movieId;
    private String contents;
    private Boolean grade; //좋아요
    private String postDate;

    public ReviewFormDto(Review review) {
        this.userId = review.getUserId();
        this.movieId = review.getMovieId();
        this.contents = review.getContents();
        this.grade = review.getGrade();
        postDate = LocalDate.now().toString();
    }

    public Review toEntity(Movie movie, User user) {
        return Review.builder()
                .user(user)
                .movie(movie)
                .contents(contents)
                .postDate(String.valueOf(LocalDate.now()))
                .grade(grade)
                .build();

    }

    @Override
    public String toString() {
        return "ReviewFormDto{" +
                "user=" + user +
                ", movie=" + movie +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", contents='" + contents + '\'' +
                ", grade=" + grade +
                '}';
    }
}
