package com.kit.movie.web;

import com.kit.movie.service.UserService;
import com.kit.movie.web.dto.UserLoginRequestDto;
import com.kit.movie.web.dto.UserLoginResponseDto;
import com.kit.movie.web.dto.UserResponseDto;
import com.kit.movie.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/signup")
    public Long save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto){
        return userService.login(requestDto);
    }
}
