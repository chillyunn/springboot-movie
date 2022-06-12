package com.kit.movie.web.dto.theater;

import com.kit.movie.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TheaterSaveRequestDto {
    private String name;

    @Builder
    public TheaterSaveRequestDto(String name) {
        this.name = name;
    }

    public Theater toEntity() {
        return Theater.builder()
                .name(name)
                .build();
    }
}