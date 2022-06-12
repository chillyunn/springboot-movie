package com.kit.movie.service;

import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.domain.timetable.TimetableRepository;
import com.kit.movie.web.dto.TimetableSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimetableService {
    private final TimetableRepository timetableRepository;

//    @Transactional
//    public Long save(TimetableSaveRequestDto requestDto){
//        return timetableRepository.save(requestDto.toEntity()).getId();
//    }

    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }
}
