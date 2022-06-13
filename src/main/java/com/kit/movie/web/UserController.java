package com.kit.movie.web;

import com.kit.movie.domain.movie.Movie;
import com.kit.movie.domain.timetable.Timetable;
import com.kit.movie.domain.user.Role;
import com.kit.movie.domain.user.User;
import com.kit.movie.service.MovieService;
import com.kit.movie.service.TimetableService;
import com.kit.movie.service.UserService;
import com.kit.movie.web.dto.timetable.TimetableResponseDto;
import com.kit.movie.web.dto.timetable.TimetableSaveRequestDto;
import com.kit.movie.web.dto.user.UserLoginRequestDto;
import com.kit.movie.web.dto.user.UserSaveRequestDto;
import com.kit.movie.web.validation.SaleValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MovieService movieService;
    private final TimetableService timetableService;

    //private final Validator validator;
    private final SaleValidation validation;
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
            @SessionAttribute(name=SessionConst.LOGIN_USER, required = false) User loginUser,
            Model model,
            @RequestParam(value = "page",defaultValue = "0") int page){
        Pageable selectedPage = PageRequest.of(page,5);
        Page<Movie> movies = movieService.findAll(selectedPage);
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
    @GetMapping("/timetables/admin")
    public String findAdminTimetable(Model model){
        List<Timetable> timetables = timetableService.findAll();
        model.addAttribute("timetables",timetables);
        return "timetables/timetable-admin-list";
    }

    @GetMapping("/timetable/admin/{id}")
    public String adminForm(@PathVariable("id") Long id, HttpSession session, Model model){
        //model.addAttribute("timetable",new TimetableSaveRequestDto());

        Timetable timetable=timetableService.findById(id);

        model.addAttribute("timetable",timetable);

        return "members/admin";
    }

    @PostMapping("/timetable/admin/{id}")
    public String adminPost(@Validated @PathVariable("id") Long id, @ModelAttribute Timetable timetable, BindingResult bindingResult){
        //validate(timetable,bindingResult);

        if (timetable.getPercentDiscount() == null || timetable.getPercentDiscount() < 0 || timetable.getPercentDiscount() > 100) {
            bindingResult.addError(new FieldError("timetable","percentDiscount","에러뜸"));
        }
        if (timetable.getFlatDiscount()== null || timetable.getFlatDiscount()<5000) {
            bindingResult.addError(new FieldError("timetable","flatDiscount","에러뜸2"));

        }
        if(bindingResult.hasErrors()){
            System.out.println("에러 안");
            log.info("errors={} ",bindingResult);
            return "timetables/admin";
        }
        Timetable timetable1=timetableService.findById(id);
        if(timetable.getFlatDiscount()==null){
            timetable1.setPercentDiscount(timetable.getPercentDiscount());
            timetable1.setPrice(timetable1.getPrice()/100*timetable.getPercentDiscount());
        }
        else{
            timetable1.setFlatDiscount(timetable.getFlatDiscount());
            timetable1.setPrice(timetable1.getPrice()-timetable.getFlatDiscount());
        }
        timetableService.save(timetable1);
        return "redirect:/";
    }
}
