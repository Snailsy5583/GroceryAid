package com.GroceryAid.GroceryAid.services;

import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.Item;
import com.GroceryAid.GroceryAid.entities.User;


public interface GroceryListService {
//    add item user
//            remove item user
//                    add list user
//                            remove list user
	
	public void addItem(GroceryListDto gListDto);
	public void deleteItem(GroceryListDto glistDto, Item item);
	public void addList(User user);
	public void deleteList(GroceryListDto gListDto);
}
