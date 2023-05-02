package com.GroceryAid.GroceryAid.controllers;

import com.GroceryAid.GroceryAid.dtos.CartDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.User;
import com.GroceryAid.GroceryAid.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AppController {
    private boolean isLoggedIn = false;
    private UserDto loggedInUser = null;

    @GetMapping("/")
    public String home()
    {
        if (!isLoggedIn)
            return "redirect:/login";
        else {
            
            return "index";
        }
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("userDto", new UserDto());
        return "register_form";
    }

    @GetMapping("/process_register")
    public ModelAndView processRegister(UserDto userDto)
    {
        ModelAndView mav =  new ModelAndView("forward:/api/v1/users/register");
        mav.addObject(userDto);

        return mav;
    }

    @GetMapping("/login")
    public String login()
    {
        if (!isLoggedIn)
            isLoggedIn = true;

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout()
    {
        isLoggedIn = false;
        return "redirect:/";
    }
}
