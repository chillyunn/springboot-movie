package com.kit.movie.service;

import com.kit.movie.domain.user.User;
import com.kit.movie.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

//    @Transactional
//    public Long save(UserSaveRequestDto userSaveRequestDto){
//
//        return userRepository.save(userSaveRequestDto.toEntity(userSaveRequestDto.getPassword())).getId();
////        userRepository.save(userSaveRequestDto.toEntity());
////        return userSaveRequestDto.getId();
//    }

    public Long save(User user){
        userRepository.save(user);
        return user.getId();
    }

    //로그인인
//    public UserLoginResponseDto login(UserLoginRequestDto requestDto){
//
//        String loginID = requestDto.getLoginID();
//        //User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" +id));
//        String password = requestDto.getPassword();
//
//        //User findUser = userRepository.findOne(loginID);
//
//        //비밀번호 일치하지 않을경우
//
//
////        return UserLoginResponseDto.builder()
////                .id(entity.getLoginID())
////                .name(entity.getName())
////                .build();
//    }

    public User login(String loginID, String password){
        User findUser = userRepository.findByLoginID(loginID);
        if(findUser!=null && findUser.getPassword().equals(password)){
            return findUser;
        }else{
            return null;
        }
    }

    public Long checkId(Long id){
        if(!userRepository.existsById(id)){
            return id;
        }
        else{
            throw new IllegalArgumentException("중복된 아이디입니다.");
        }
    }

//    public UserResponseDto findByloginID(String loginID){
//        User entity = userRepository
//    }

    public User findById(Long id){
        User entity = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 아이디의 회원정보가 없습니다. id=" +id));
        return entity;
    }


}
