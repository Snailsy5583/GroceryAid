package com.GroceryAid.GroceryAid.controllers;


import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.User;
import com.GroceryAid.GroceryAid.repositories.UserRepository;
import com.GroceryAid.GroceryAid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

//    @GetMapping("/register")
//    public String showRegistrationForm(User user) {
//        User.addAttribute("user", new User());
//        return "signup_form";
//    }

    @PostMapping("/register")
    public String addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }
    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        return "register_success";
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserDto userDto){
        return userService.userLogin(userDto);
    }
}