package com.kit.movie.domain.actor;

import com.kit.movie.domain.movie_actor.Movie_Actor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birth;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "actor")
    private List<Movie_Actor> movie_actors = new ArrayList<>();

}
