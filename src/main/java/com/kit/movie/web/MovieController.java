package com.kit.movie.web;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.review.Review;
import com.kit.movie.service.MovieService;
import com.kit.movie.service.ReviewService;
import com.kit.movie.web.dto.movie.MovieResponseDto;
import com.kit.movie.web.dto.movie.MovieSaveRequestDto;
import com.kit.movie.web.dto.review.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

//    @GetMapping("/")
//    public String index(Model model){
//        Pageable firstPage = PageRequest.of(0,3);
//        Page<Movie> movies = movieService.findAll(firstPage);
//        model.addAttribute("movie",movies);
//        return "redirect:/";
//    }
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
    @GetMapping("/movies/reservatedOrder")
    public String findAllOrderReservated(Model model){
        Sort sort1 = Sort.by("reservated").descending();
        PageRequest pageRequest = PageRequest.of(0,11,sort1);
        Page<Movie> pageBy = movieService.findAll(pageRequest);
        model.addAttribute("movies",pageBy);
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
        for (ReviewResponseDto dto:reviewResponseDtos
             ) {
            System.out.println( reviewResponseDtos.toString());
        }
        model.addAttribute("reviews", reviewResponseDtos);

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