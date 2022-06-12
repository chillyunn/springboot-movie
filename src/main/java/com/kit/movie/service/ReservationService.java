package com.kit.movie.service;

import com.kit.movie.domain.reservation.ReservationRepository;
import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.domain.timetable.TimetableRepository;
import com.kit.movie.domain.user.User;
import com.kit.movie.domain.user.UserRepository;
import com.kit.movie.web.dto.reservation.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final TimetableRepository timetableRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long save(ReservationSaveRequestDto requestDto) {
        Timetable timetable = timetableRepository.findById(requestDto.getTimetableId()).orElseThrow(()-> new IllegalArgumentException("존재하지않는 Timetable"));
        User user =userRepository.findByName(requestDto.getUserName());

        return reservationRepository.save(requestDto.toEntity(user,timetable)).getId();
    }

}
