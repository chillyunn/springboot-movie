package com.kit.movie.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCheckIdRequestDto {
    private Long id;

    @Builder
    public UserCheckIdRequestDto(Long id){
        this.id=id;
    }

}
