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
	
	@PostMapping("/get_glist")
	public GroceryListDto getGroceryList(@RequestBody UserDto userDto) {
		
		
		//return new GroceryListDto(groceryListRepository.findByUser(new User(userDto)).get());
		return null;
	}
	
	@GetMapping
	public String testSaveGroceryApi() {
		
		/*GroceryList groceryList = new GroceryList();
		
		groceryList.setListId(2L);
		groceryList.setUser(userRepository.findByUserName("kunal").get());
		Item item = new Item();
		item.setItemName("soap");
		item.setItemPrice(10);
		item.setItemQuantity(1);
		item.setWalmartSKU(12L);
		item.setItemId(1L);
		
		ArrayList<Item> items = new ArrayList<>();
		items.add(item);
		
		groceryList.setItemsList(items);
		
		groceryListRepository.save(groceryList);*/
		return "";
	}
	
}
