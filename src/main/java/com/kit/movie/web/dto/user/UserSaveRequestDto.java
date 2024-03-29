package com.kit.movie.web.dto.user;

import com.kit.movie.domain.user.Role;
import com.kit.movie.domain.user.User;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserSaveRequestDto {
    private Long id;
    private String loginID;
    private String name;
    private String password;
    private Role role;

//    @Builder
//    public UserSaveRequestDto(Long id, String name, String password){
//        this.id=id;
//        this.name=name;
//        this.password = password;
//    }
//
//    public User toEntity(String password){
//        return User.builder()
//                .id(id)
//                .name(name)
//                .password(password)
//                .build();
//    };

    public UserSaveRequestDto(User user){
        this.id=user.getId();
        this.name=user.getName();
        this.password=user.getPassword();
    }
}
