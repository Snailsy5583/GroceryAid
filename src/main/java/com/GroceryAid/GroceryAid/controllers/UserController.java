package com.GroceryAid.GroceryAid.controllers;


import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.User;
import com.GroceryAid.GroceryAid.repositories.GroceryListRepository;
import com.GroceryAid.GroceryAid.repositories.UserRepository;
import com.GroceryAid.GroceryAid.services.GroceryListService;
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
    private UserRepository userRepository;
    @Autowired
    private GroceryListController groceryListController;

    @PostMapping("/register")
    public String addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody UserDto userDto){
        return userService.userLogin(userDto);
    }
}