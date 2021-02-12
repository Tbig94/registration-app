package com.resgistration_app.web.controller;

import com.resgistration_app.service.UserService;
import com.resgistration_app.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    // REGISTRATION
    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@Valid @ModelAttribute("user") UserRegistrationDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "/registration";
        }
        userService.save(dto);
        return "redirect:/registration?success";
    }

    // LOGIN
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/user-list")
    public String listAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "user-list";
    }

}
