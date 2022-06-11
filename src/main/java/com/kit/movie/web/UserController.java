package com.kit.movie.web;

import com.kit.movie.domain.user.Role;
import com.kit.movie.domain.user.User;
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

    @GetMapping("users/join")
    public String createForm(Model model){
        model.addAttribute("user", new UserSaveRequestDto());
        return "members/join-form";
    }

    @PostMapping("/users/join")
    public String addMember(@ModelAttribute UserSaveRequestDto userSaveRequestDto){
        //User user = new User(userSaveRequestDto.getId(), userSaveRequestDto.getName(), userSaveRequestDto.getPassword());
        User user = new User(userSaveRequestDto.getLoginID(), userSaveRequestDto.getName(), userSaveRequestDto.getPassword(), Role.USER);

        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String loginForm(@ModelAttribute("loginForm") UserLoginRequestDto userLoginRequestDto){
        return "members/login";
    }

//    @PostMapping("/user/login")
//    public String login(@ModelAttribute UserLoginRequestDto userLoginRequestDto){
//
//    }
}
