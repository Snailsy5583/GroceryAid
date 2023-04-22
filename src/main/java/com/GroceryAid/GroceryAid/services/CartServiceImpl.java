package com.GroceryAid.GroceryAid.services;

import com.GroceryAid.GroceryAid.dtos.CartDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.Cart;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.Item;
import com.GroceryAid.GroceryAid.entities.User;
import com.GroceryAid.GroceryAid.repositories.CartRepository;
import com.GroceryAid.GroceryAid.repositories.GroceryListRepository;
import com.GroceryAid.GroceryAid.repositories.ItemRepository;
import com.GroceryAid.GroceryAid.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private GroceryListRepository groceryListRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public boolean addToCart(CartDto cartDto) {
		
		try {
			Cart cart = new Cart();
			cart.setCartId(cartDto.getCartId());
			
			Optional<User> user = userRepository.findByUserName(cartDto.getUserName());
			cart.setUserId(user.get());
			GroceryList groceryList = new GroceryList(cartDto.getGroceries());
			
		
			List<Item> items =	itemRepository.saveAll(groceryList.getItemsList());
			groceryList.setItemsList(items);
			 groceryList =	groceryListRepository.save(groceryList);
			
			cart.setGroceries(groceryList);
			
		//	Cart cart1 = cartRepository.save(cart);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return true;
	}
	
	
	/*elect c1_0.cart_id,g1_0.grocery_id,u1_0.user_id,u1_0.email,u1_0.password,u1_0.user_name from
	cart c1_0 left join grocery_items g1_0 on g1_0.grocery_id=c1_0.grocery_id left join
	users u1_0 on u1_0.user_id=c1_0.user_user_id where c1_0.cart_id=?
	*/
	
}
