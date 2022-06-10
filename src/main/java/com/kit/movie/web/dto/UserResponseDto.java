package com.kit.movie.web.dto;

import com.kit.movie.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String name;
    private String password;

    public UserResponseDto(User entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.password=entity.getPassword();
    }
}
