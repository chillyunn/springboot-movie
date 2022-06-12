package com.kit.movie.domain.reservation;

import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.seat.Seat;
import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.domain.user.User;
import lombok.Builder;
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
    @JoinColumn(name = "TIMETABLE_ID")
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "reservation")
    private List<Seat> seats = new ArrayList<>();

    @Builder
    public Reservation(Timetable timetable, User user) {
        this.timetable = timetable;
        this.user = user;
    }

    @Transient
    private Long timetableId;
    @Transient
    private String userName;
}
