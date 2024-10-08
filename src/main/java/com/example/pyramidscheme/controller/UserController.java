package com.example.pyramidscheme.controller;

import com.example.pyramidscheme.model.request.UserRequestDto;
import com.example.pyramidscheme.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute UserRequestDto userRequestDto) {
        userService.createUser(userRequestDto);
        return "redirect:/users/";
    }
}
