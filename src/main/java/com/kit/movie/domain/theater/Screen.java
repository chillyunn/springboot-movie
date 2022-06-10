package com.kit.movie.domain.theater;

import com.kit.movie.domain.seat.Seat;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AttributeOverrides({
    @AttributeOverride(name = "id",column = @Column(name = "SCREEN_ID"))
})
@Entity
public class Screen extends Theater{
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "screen")
    List<Seat> seats = new ArrayList<>();
}
