package com.GroceryAid.GroceryAid.services;

import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    @Transactional
    String addUser(UserDto userDto);

    String userLogin(UserDto userDto);

    GroceryListDto createGroceryList(UserDto userDto);
    
    
    
}
