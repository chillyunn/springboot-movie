package com.kit.movie.domain.reservation;

import com.kit.movie.domain.reservation_seat.Reservation_Seat;
import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userResv;

    @OneToMany(mappedBy = "reservation")
    private List<Reservation_Seat> reservationSeats = new ArrayList<>();

}
