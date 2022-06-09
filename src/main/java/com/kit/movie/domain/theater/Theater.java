package com.kit.movie.domain.theater;

import com.kit.movie.domain.screen.Screen;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public  class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    @OneToMany(mappedBy = "theater")
    List<Screen> screens = new ArrayList<>();




}
