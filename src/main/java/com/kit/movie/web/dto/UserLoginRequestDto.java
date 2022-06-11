package com.kit.movie.web.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Data
public class UserLoginRequestDto {
    private String loginID;
    private String password;

//    @Builder
//    public UserLoginRequestDto(String loginID, String password){
//        this.loginID=loginID;
//        this.password=password;
//    }
}
