package com.GroceryAid.GroceryAid.services;

import com.GroceryAid.GroceryAid.dtos.CartDto;

public interface CartService {
//add grocerylisttocart
//        remove grocerylist from cart
	
	
	public boolean addToCart(CartDto cartDto);

}
