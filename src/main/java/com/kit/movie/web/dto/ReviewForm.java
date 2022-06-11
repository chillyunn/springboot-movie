package com.kit.movie.web.dto;

import com.kit.movie.domain.review.Review;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewForm {
    private Long id;

    private String name;

    private String contents;

    private boolean grade; //좋아요

    public ReviewForm(Review review){
        this.id = review.getId();
        this.name = review.getName();
        this.contents = review.getContents();
        this.grade = review.isGrade();

    }
}
