package com.kit.movie.web.dto.review;

import com.kit.movie.domain.review.Review;
import com.kit.movie.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewResponseDto {
    private User user;
    private String contents, postDate;
    private Integer likeCount;
    private Boolean grade;

    public ReviewResponseDto(Review entity){
        this.user =entity.getUser();
        this.contents = entity.getContents();
        this.postDate = entity.getPostDate();
        this.likeCount = entity.getLikeCount();
        this.grade = entity.getGrade();
    }
}
