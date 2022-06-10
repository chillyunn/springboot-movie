package com.kit.movie.domain.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String reservationRate; //?

    @Column(nullable = false)
    private Date releaseDate; // import util? sql?

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String genre;
}
