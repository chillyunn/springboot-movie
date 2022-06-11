package com.kit.movie.web.dto;

import com.kit.movie.domain.screen.Screen;
import com.kit.movie.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScreenSaveRequestDto {
    String name;
    Integer floor;
    Theater theater;

    @Builder
    public ScreenSaveRequestDto(String name, Integer floor, Theater theater) {
        this.name = name;
        this.floor = floor;
        this.theater = theater;
    }
    public Screen toEntity(){
        return Screen.builder()
                .name(name)
                .floor(floor)
                .theater(theater)
                .build();
    }
}
