package com.kit.movie.domain.seat;


import com.kit.movie.domain.reservation.Reservation;
import com.kit.movie.domain.timetable.Timetable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean isBooked;

    @ManyToOne(fetch = FetchType.LAZY)
    private Timetable timetable;

    @ManyToOne(fetch = FetchType.LAZY)
    private Reservation reservation;
    @Builder
    public Seat(Long id, String name, Boolean isBooked, Timetable timetable) {
        this.id = id;
        this.name = name;
        this.isBooked = isBooked;
        this.timetable = timetable;
    }
}
