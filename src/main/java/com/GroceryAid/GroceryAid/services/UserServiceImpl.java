package com.GroceryAid.GroceryAid.services;

import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.User;
import com.GroceryAid.GroceryAid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(new User(userDto));
        return null;
    }

    @Override
    public String userLogin(UserDto userDto) {
        Optional<User> user = userRepository.findByUserName(userDto.getUserName());
        if (user.isPresent())
        {
            String encodedPassword = passwordEncoder.encode(userDto.getPassword());
            if (encodedPassword.equals(user.get().getPassword()))
            {
                return "Login Success.";
            }
            else
            {
                return "Username exists.";
            }
        }
        return "Login failed.";
    }

    @Override
    public GroceryListDto createGroceryList(UserDto userDto) {

        return null;
    }
    
   
}
