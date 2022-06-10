package com.kit.movie.domain.theater;

import com.kit.movie.domain.screen.Screen;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public  class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "theater")
    List<Screen> screens = new ArrayList<>();

    @Builder
    public Theater(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
