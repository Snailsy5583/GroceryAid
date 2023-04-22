package com.GroceryAid.GroceryAid.controllers;

import com.GroceryAid.GroceryAid.dtos.CartDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public String addToCart(@RequestBody CartDto cartDto)	{
		cartService.addToCart(cartDto);
		
		return "";
	}
	
	@GetMapping("/get")
	public String getCart(long userId) {
	
		return null;
	}
	
	
	
}
