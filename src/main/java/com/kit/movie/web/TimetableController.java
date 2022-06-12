//package com.kit.movie.web;
//
//import com.kit.movie.domain.timetable.Timetable;
//import com.kit.movie.domain.timetable.TimetableRepository;
//import com.kit.movie.service.TimetableService;
//import com.kit.movie.web.dto.TimetableResponseDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RequiredArgsConstructor
//@Controller
//public class TimetableController {
//    private final TimetableService timetableService;
//
//    @GetMapping("/timetables")
//    public String findAll(Model model){
//        List<Timetable> timetables = timetableService.findAll();
//
////        List<TimetableResponseDto> responseDtos = timetables
////                .stream()
////                .map(t-> new TimetableResponseDto(t))
////                .collect(Collectors.toList());
////        model.addAttribute("timetables",responseDtos);
//        return "timetables/timetable";
//    }
//}
