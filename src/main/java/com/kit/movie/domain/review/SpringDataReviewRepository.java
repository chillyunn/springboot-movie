package com.kit.movie.domain.review;

import com.kit.movie.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataReviewRepository  extends JpaRepository<Review, Long> {
    List<Review> findByMovie(Movie movie);
}
