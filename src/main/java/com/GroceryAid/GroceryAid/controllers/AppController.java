package com.GroceryAid.GroceryAid.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/login")
    public String loginUser() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupUser() {
        return "signup";
    }

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        return "index";
    }

    @GetMapping("/Grocerylist/user={user_id}/gList={gList_id}")
    public String editGroceryList(Model model, HttpSession session) {

        return "grocery_list";
    }
}
