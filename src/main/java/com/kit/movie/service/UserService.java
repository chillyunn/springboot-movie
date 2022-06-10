package com.kit.movie.service;

import com.kit.movie.domain.user.User;
import com.kit.movie.domain.user.UserRepository;
import com.kit.movie.web.dto.UserLoginRequestDto;
import com.kit.movie.web.dto.UserLoginResponseDto;
import com.kit.movie.web.dto.UserResponseDto;
import com.kit.movie.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto){

        return userRepository.save(userSaveRequestDto.toEntity(userSaveRequestDto.getPassword())).getId();
    }

    @Transactional //로그인인
    public UserLoginResponseDto login(UserLoginRequestDto requestDto){
        Long id = requestDto.getId();
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" +id));
        String password = requestDto.getPassword();
        //비밀번호 일치하지 않을경우


        return UserLoginResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Transactional
    public Long checkId(Long id){
        if(!userRepository.existsById(id)){
            return id;
        }
        else{
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
    }

    public UserResponseDto findById(Long id){
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" +id));
        return new UserResponseDto(entity);
    }


}
