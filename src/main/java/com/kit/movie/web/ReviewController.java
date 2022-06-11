package com.kit.movie.web;

import com.kit.movie.domain.review.Review;
import com.kit.movie.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("reviews")
    public String reviewList(Model model){
        List<Review> reviews = reviewService.findReviews();

        return "reviews/~~~";
    }

    @PostMapping("review/edit")
    public String updateItem(BookForm form){
        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());
        itemService.saveItem(book);
        return "redirect:/items";
    }
}
