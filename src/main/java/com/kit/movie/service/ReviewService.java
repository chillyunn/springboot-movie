package com.kit.movie.service;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.movie.MovieRepository;
import com.kit.movie.domain.review.Review;
import com.kit.movie.domain.review.ReviewRepository;
import com.kit.movie.domain.review.SpringDataReviewRepository;
import com.kit.movie.domain.user.User;
import com.kit.movie.domain.user.UserRepository;
import com.kit.movie.web.dto.ReviewFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final SpringDataReviewRepository springDataReviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public void saveReview(ReviewFormDto review, Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재x movie"));
        System.out.println("review = " + review.toString() + ", id = " + id);

        User user = userRepository.findById(review.getUserId()).orElseThrow(()-> new IllegalArgumentException("존재x user"));

        reviewRepository.save(review.toEntity(movie, user));

    }
    public List<Review> findReviews() { return reviewRepository.findAll(); }
    public Review findOne(Long reviewId) { return reviewRepository.findOne(reviewId); }

    public List<Review> findByMovie(Movie movie) {
        return springDataReviewRepository.findByMovie(movie);
    }
}
