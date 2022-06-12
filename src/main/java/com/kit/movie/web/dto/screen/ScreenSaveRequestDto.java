package com.kit.movie.web.dto.screen;

import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.theater.Theater;
import com.kit.movie.service.TheaterService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScreenSaveRequestDto {
    Integer name;
    Integer floor;
    String type;
    String theaterName;

    @Builder
    public ScreenSaveRequestDto(String type,Integer name, Integer floor) {
        this.name = name;
        this.floor = floor;
    }
    public Screen toEntity(Theater theater){
        return Screen.builder()
                .name(name)
                .floor(floor)
                .theater(theater)
                .build();
    }
}
