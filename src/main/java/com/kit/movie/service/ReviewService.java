package com.kit.movie.service;

import com.kit.movie.domain.review.Review;
import com.kit.movie.domain.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public void saveReview(Review review) { reviewRepository.save(review); }
    public List<Review> findReviews() { return reviewRepository.findAll(); }
    public Review findOne(Long reviewId) { return reviewRepository.findOne(reviewId); }

}
