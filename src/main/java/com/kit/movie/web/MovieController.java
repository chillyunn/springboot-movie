package com.kit.movie.web;

import com.kit.movie.service.MovieService;
import com.kit.movie.web.dto.MovieResponseDto;
import com.kit.movie.web.dto.MovieSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MovieController {
    private final MovieService movieService;

//    @GetMapping("/movies") //id로 영화 찾기 - 불필요해보임
//    public MovieResponseDto findById(@PathVariable Long id){
//        return movieService.findById(id);
//    }
    @GetMapping("/movies/add")
    public String saveForm(Model model){
        model.addAttribute("movie",new MovieSaveRequestDto());
        return "movies/add-form";
    }

    @PostMapping("/movies/add")
    public Long save(MovieSaveRequestDto requestDto) {
        return movieService.save(requestDto);
    }

}