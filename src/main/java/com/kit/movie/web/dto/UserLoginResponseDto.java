package com.kit.movie.web.dto;

import com.kit.movie.domain.user.User;
import lombok.Builder;

public class UserLoginResponseDto {
    private Long id;
    private String name;

    @Builder
    public UserLoginResponseDto(Long id, String name){
        this.id=id;
        this.name=name;
    }

    public User toEntity(){
        return User.builder()
                .id(id)
                .name(name)
                .build();
    }
}
