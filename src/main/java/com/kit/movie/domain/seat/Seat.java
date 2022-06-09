package com.kit.movie.domain.seat;

import com.kit.movie.domain.screen.Screen;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;
    @Column
    private String name;

}
