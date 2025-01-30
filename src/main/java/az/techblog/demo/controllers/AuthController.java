package az.techblog.demo.controllers;

import az.techblog.demo.dto.userDtos.UserRegisterDto;
import az.techblog.demo.services.impls.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
    @GetMapping("/register")
    public String register() {
        return "auth/register";
    }
    @PostMapping("/register")
    public String register(@Valid UserRegisterDto userRegisterDto) {
        userService.registerUser(userRegisterDto);
        return "redirect:/login";
    }
}
