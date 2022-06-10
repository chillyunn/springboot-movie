package com.kit.movie.domain.review;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; //회원 이름

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private Date postDate; //util? sql?

    @Column(nullable = false)
    private int likeCount;

//    @ManyToOne
}
