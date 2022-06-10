package com.kit.movie.domain.seat;

import com.kit.movie.domain.reservation_seat.Reservation_Seat;
import com.kit.movie.domain.screen.Screen;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "seat")
    private List<Reservation_Seat> reservationSeats = new ArrayList<>();

}
