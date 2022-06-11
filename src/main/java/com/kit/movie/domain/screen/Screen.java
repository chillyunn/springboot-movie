package com.kit.movie.domain.screen;

import com.kit.movie.domain.reservation.Reservation;
import com.kit.movie.domain.seat.Seat;
import com.kit.movie.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;

    @Transient
    private String theaterName;

    @OneToMany(mappedBy = "screen")
    List<Seat> seats = new ArrayList<>();

    @OneToMany(mappedBy = "screen")
    List<Reservation> reservations = new ArrayList<>();

    @Builder
    public Screen(String name, Integer floor, Theater theater) {
        this.name = name;
        this.floor = floor;
        this.theater = theater;
        theater.getScreens().add(this);
    }
}