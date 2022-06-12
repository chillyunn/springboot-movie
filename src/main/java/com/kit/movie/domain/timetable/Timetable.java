package com.kit.movie.domain.timetable;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.seat.Seat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.Range;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TIMETABLES")
public class Timetable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private Integer price;

    @Range(min=0, max=100)
    private Integer percentDiscount;

    @Min(5000)
    private Integer flatDiscount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToMany(mappedBy = "timetable",cascade = CascadeType.ALL)
    private List<Seat> seats= new ArrayList<>();


    @Transient
    private Long screenId;
    @Transient
    private Long movieId;

    @Builder
    public Timetable(String time, Integer price, Screen screen, Movie movie) {
        this.time = time;
        this.price = price;
        this.screen = screen;
        this.movie = movie;
    }

}
