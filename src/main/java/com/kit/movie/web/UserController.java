package com.kit.movie.web;

import com.kit.movie.service.UserService;
import com.kit.movie.web.dto.UserLoginRequestDto;
import com.kit.movie.web.dto.UserLoginResponseDto;
import com.kit.movie.web.dto.UserResponseDto;
import com.kit.movie.web.dto.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public UserResponseDto findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("user/join")
    public String addMember(Model model){
        model.addAttribute("member", new UserSaveRequestDto());
        return "members/join-form.html";
    }

    @PostMapping("/user/join")
    public Long save(@RequestBody UserSaveRequestDto requestDto){
        return userService.save(requestDto);
    }

    @PostMapping("/user/login")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto){
        return userService.login(requestDto);
    }
}
