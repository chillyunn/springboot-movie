package com.kit.movie.web;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.review.Review;
import com.kit.movie.service.MovieService;
import com.kit.movie.service.ReviewService;
import com.kit.movie.web.dto.MovieResponseDto;
import com.kit.movie.web.dto.MovieSaveRequestDto;
import com.kit.movie.web.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class MovieController {
    private final MovieService movieService;
    private final ReviewService reviewService;

    @GetMapping("/movies") //id로 영화 찾기 - 불필요해보임
    public String findAll(Model model) {
        List<Movie> movies = movieService.findAll();

        List<MovieResponseDto> responseDtos = movies
                .stream()
                .map(m -> new MovieResponseDto(m))
                .collect(Collectors.toList());
        model.addAttribute("movies", responseDtos);

        return "movies/movie-list";
    }

    @GetMapping("/movies/detail")
    public String findById(Model model, @RequestParam Long movieId) {
        Movie movie = movieService.findById(movieId);
        MovieResponseDto movieResponseDto = new MovieResponseDto(movie);
        model.addAttribute("movie", movieResponseDto);

        List<Review> reviews = reviewService.findByMovie(movie);
        List<ReviewResponseDto> reviewResponseDtos = reviews
                .stream()
                .map(r -> new ReviewResponseDto(r))
                .collect(Collectors.toList());
        model.addAttribute("review", reviewResponseDtos);

        return "movies/movie-detail";
    }

    @GetMapping("/movies/add")
    public String saveForm(Model model) {
        model.addAttribute("movie", new MovieSaveRequestDto());
        return "movies/movie-form";
    }

    @PostMapping("/movies/add")
    public String save(@ModelAttribute MovieSaveRequestDto requestDto) {
        movieService.save(requestDto);
        return "redirect:/movies";
    }

}