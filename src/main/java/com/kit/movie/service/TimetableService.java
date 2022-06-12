package com.kit.movie.service;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.movie.MovieRepository;
import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.screen.ScreenRepository;
import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.domain.timetable.TimetableRepository;
import com.kit.movie.web.dto.timetable.TimetableSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimetableService {
    private final MovieRepository movieRepository;
    private final ScreenRepository screenRepository;
    private final TimetableRepository timetableRepository;

    @Transactional
    public Long save(TimetableSaveRequestDto requestDto){
        Movie movie = movieRepository.findById(requestDto.getMovieId()).orElseThrow(()->new IllegalArgumentException("존재하지않는 Movie"));
        Screen screen = screenRepository.findById(requestDto.getScreenId()).orElseThrow(()->new IllegalArgumentException("존재하지않는 Screen"));
        return timetableRepository.save(requestDto.toEntity(screen,movie)).getId();
    }

    public Long save(Timetable timetable){
        timetableRepository.save(timetable);
        return timetable.getId();
    }

    @Transactional
    public List<Timetable> findAll() {
        return timetableRepository.findAll();
    }

    @Transactional
    public Timetable findById(Long id) {
        return timetableRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("존재하지않는 timetable"));
    }
}
