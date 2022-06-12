package com.kit.movie.web;

import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.service.TimetableService;
import com.kit.movie.web.dto.timetable.TimetableResponseDto;
import com.kit.movie.web.dto.timetable.TimetableSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class TimetableController {
    private final TimetableService timetableService;

    @GetMapping("/timetables")
    public String findAll(Model model){
        List<Timetable> timetables = timetableService.findAll();

        List<TimetableResponseDto> responseDtos = timetables
                .stream()
                .map(t-> new TimetableResponseDto(t))
                .collect(Collectors.toList());
        model.addAttribute("timetables",responseDtos);
        return "timetables/timetable-list";
    }
    @GetMapping("/timetable")
    public String findById(Model model,
                           @RequestParam Long id){
        Timetable timetable = timetableService.findById(id);
        List<Timetable> timetables = new ArrayList<>();
        timetables.add(timetable);
        List<TimetableResponseDto> responseDtos = timetables
                .stream()
                .map(t-> new TimetableResponseDto(t))
                .collect(Collectors.toList());
        model.addAttribute("timetables",responseDtos);
        return "timetables/timetable-list";
    }
    @GetMapping("/timetables/add")
    public String saveForm(Model model){
        model.addAttribute("timetable", new TimetableSaveRequestDto());
        return "timetables/timetable-form";
    }
    @PostMapping("/timetables/add")
    public String save(@ModelAttribute TimetableSaveRequestDto requestDto){
        timetableService.save(requestDto);
        return "redirect:/timetables";
    }
}
