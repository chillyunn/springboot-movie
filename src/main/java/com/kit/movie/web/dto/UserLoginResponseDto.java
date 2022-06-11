package com.kit.movie.web.dto;

import com.kit.movie.domain.user.User;
import lombok.Builder;

public class UserLoginResponseDto {
    private String id;
    private String name;

    @Builder
    public UserLoginResponseDto(String id, String name){
        this.id=id;
        this.name=name;
    }

    public User toEntity(){
        return User.builder()
                .loginID(id)
                .name(name)
                .build();
    }
}
