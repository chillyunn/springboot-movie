package com.kit.movie.domain.actor;

import com.kit.movie.domain.movie.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Movie_Actor {//영화이름(FK), 배우이름(FK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

}
