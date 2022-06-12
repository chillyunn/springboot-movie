package com.kit.movie.web;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.user.Role;
import com.kit.movie.domain.user.User;
import com.kit.movie.service.MovieService;
import com.kit.movie.service.UserService;
import com.kit.movie.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MovieService movieService;

//    @GetMapping("/user/{id}")
//    public UserResponseDto findById(@PathVariable Long id){
//        return userService.findById(id);
//    }

    @GetMapping("/user/{id}")
    public String myInfo(@PathVariable("id") Long id, HttpSession session, Model model){
        //User user = userService.findById(session.getAttribute("name"));
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "members/myInfo";
    }

    @GetMapping("/")
    public String home(
            @SessionAttribute(name=SessionConst.LOGIN_USER, required = false) User loginUser, Model model){
        Pageable firstPage = PageRequest.of(0,3);
        Page<Movie> movies = movieService.findAll(firstPage);
        model.addAttribute("movies",movies);
        if(loginUser==null){
            return "index";
        }

        model.addAttribute("user", loginUser);

        return "index";
    }

    @GetMapping("/users/join")
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
    public String loginForm(Model model){
        model.addAttribute("login", new UserLoginRequestDto());
        return "members/login";
    }

    @PostMapping("/user/login")
    public String login(@Validated @ModelAttribute UserLoginRequestDto userLoginRequestDto,
                        BindingResult bindingResult,
                        HttpServletRequest request,
                        @RequestParam(defaultValue = "/") String redirectURL){
        if(bindingResult.hasErrors()){
            return "members/login";
        }
        User loginUser= userService.login(userLoginRequestDto.getLoginID(), userLoginRequestDto.getPassword());
        if(loginUser == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "members/login";
        }

        //로그인 성공 처리
        //세션이 있으면 있는 세션반환, 없으면 신규 세션을 생성

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.LOGIN_USER, loginUser);
        return "redirect:"+redirectURL;
    }

    @GetMapping("/user/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/user/admin")
    public String adminForm(Model model){
        model.addAttribute("timetable",new TimetableRequestDto());
        return "members/admin";
    }
}
