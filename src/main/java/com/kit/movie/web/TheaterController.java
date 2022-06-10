package com.kit.movie.web;

import com.kit.movie.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TheaterController {
    private final TheaterService theaterService;

    @GetMapping("timetables")
    public String timetableList(Model model){

        return "theaters/timetable.html";
    }
}
