package com.kit.movie.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    //List<Movie> findAllOrderByReservationRate();
}
