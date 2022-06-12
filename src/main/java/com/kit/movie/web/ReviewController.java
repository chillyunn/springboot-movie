package com.kit.movie.web;

import com.kit.movie.domain.review.Review;
import com.kit.movie.service.ReviewService;
import com.kit.movie.web.dto.ReviewForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("reviews/new")
    public String create(@Validated @ModelAttribute ReviewForm reviewForm, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
//            log.info("errors = {} ", bindingResult);
            return "reviews/review-form";
        }
        //model.addAttribute("bookForm",updateSaveForm)
        Review review = new Review();
        review.setName(reviewForm.getName());
        review.setContents(reviewForm.getContents());
        review.setGrade(reviewForm.isGrade());

        reviewService.saveReview(review);
        return "redirect:/";
    }

    @GetMapping("reviews")
    public String reviewList(Model model){
        List<Review> reviews = reviewService.findReviews();

        return "reviews/~~~";
    }

    @PostMapping("review/edit")
    public String updateReview(ReviewForm form){
        Review review = new Review();
        review.setId(form.getId());
        review.setName(form.getName());
        review.setContents(form.getContents());
        review.setGrade(form.isGrade());

        reviewService.saveReview(review);
        return "redirect:/items";
    }
}
