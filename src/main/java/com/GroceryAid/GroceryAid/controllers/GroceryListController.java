package com.GroceryAid.GroceryAid.controllers;

import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.Item;
import com.GroceryAid.GroceryAid.entities.User;
import com.GroceryAid.GroceryAid.repositories.GroceryListRepository;
import com.GroceryAid.GroceryAid.repositories.UserRepository;
import com.GroceryAid.GroceryAid.services.GroceryListService;
import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/glist")
public class GroceryListController {
	@Autowired
	private GroceryListService groceryListService;
	@Autowired
	private GroceryListRepository groceryListRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/get_glist/{gListID}")
	public GroceryListDto getGroceryList(@RequestBody UserDto userDto, Long gListID) {
		var gList = groceryListRepository.findById(gListID);
		if (gList.isEmpty() || gList.get().getUser().getUserId() != userDto.getUserId())
			return null;
		
		return new GroceryListDto(gList.get());
	}
	
}
