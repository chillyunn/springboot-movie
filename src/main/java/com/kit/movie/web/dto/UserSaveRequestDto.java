package com.kit.movie.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String title;

    @Builder
    public UserSaveRequestDto(){

    }
}
