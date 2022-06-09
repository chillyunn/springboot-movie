package com.kit.movie.domain.theater;

import javax.persistence.*;

@MappedSuperclass
public abstract class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




}
