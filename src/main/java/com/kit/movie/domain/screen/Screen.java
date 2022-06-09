package com.kit.movie.domain.screen;

import com.kit.movie.domain.seat.Seat;
import com.kit.movie.domain.theater.Theater;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Screen {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "screen")
    List<Seat> seats = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;
}
