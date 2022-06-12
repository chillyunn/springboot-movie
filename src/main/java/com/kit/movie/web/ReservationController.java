package com.kit.movie.web;

import com.kit.movie.service.ReservationService;
import com.kit.movie.web.dto.reservation.ReservationResponseDto;
import com.kit.movie.web.dto.reservation.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class ReservationController {
    private final ReservationService reservationService;


    @GetMapping("/ticket/add")
    public String saveForm(Model model ,@RequestParam Long id){
        model.addAttribute("reservation",new ReservationSaveRequestDto());
        return "reservations/reservation-form";
    }
    @PostMapping("/ticket/add")
    public String save(@ModelAttribute ReservationSaveRequestDto requestDto,
                       @RequestParam Long id){
        reservationService.save(requestDto);
        return "redirect:/timetables";

    }
}
