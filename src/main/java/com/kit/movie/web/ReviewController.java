package com.kit.movie.web;

import com.kit.movie.domain.review.Review;
import com.kit.movie.domain.user.User;
import com.kit.movie.service.ReviewService;
import com.kit.movie.web.dto.review.ReviewFormDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ReviewController {
    private final ReviewService reviewService;

//    @PostMapping("reviews/new")
//    public String create(@Validated @ModelAttribute ReviewForm reviewForm, BindingResult bindingResult, Model model){
//        if (bindingResult.hasErrors()) {
////            log.info("errors = {} ", bindingResult);
//            return "reviews/review-form";
//        }
//        //model.addAttribute("bookForm",updateSaveForm)
//        Review review = new Review();
//        review.setName(reviewForm.getName());
//        review.setContents(reviewForm.getContents());
//        review.setGrade(reviewForm.getGrade());
//
//        reviewService.saveReview(review, );
//        return "redirect:/";
//    }

    @GetMapping("reviews")
    public String reviewList(Model model) {
        List<Review> reviews = reviewService.findReviews();

        return "reviews/~~~";
    }

//    @PostMapping("review/edit")
//    public String updateReview(ReviewForm form){
//        Review review = new Review();
//        review.setId(form.getId());
//        review.setName(form.getName());
//        review.setContents(form.getContents());
//        review.setGrade(form.getGrade());
//
//        reviewService.saveReview(review);
//        return "redirect:/items";
//    }

    @GetMapping("/reviews/{id}/add")
    public String saveForm(Model model, @PathVariable Long id, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute(SessionConst.LOGIN_USER);
        model.addAttribute("review", new ReviewFormDto());
        model.addAttribute("movieId", id);
        model.addAttribute("user", user);
        return "reviews/review-form";
    }

    @PostMapping("/reviews/{id}/add")
    public String save(@ModelAttribute ReviewFormDto reviewFormDto, @PathVariable Long id) {
        reviewService.saveReview(reviewFormDto, id);
        return "redirect:/movies/detail?movieId=" + id;
    }

}
