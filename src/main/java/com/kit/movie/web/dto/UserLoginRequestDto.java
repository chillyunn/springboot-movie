package com.kit.movie.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequestDto {
    private Long id;
    private String password;

    @Builder
    public UserLoginRequestDto(Long id, String password){
        this.id=id;
        this.password=password;
    }
}
