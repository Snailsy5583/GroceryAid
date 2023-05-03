package com.GroceryAid.GroceryAid.services;

import com.GroceryAid.GroceryAid.dtos.CartDto;
import com.GroceryAid.GroceryAid.dtos.DeleteGroceryListDto;
import com.GroceryAid.GroceryAid.dtos.DeleteItemDto;
import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
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

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {
	
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
		
		Cart cart = new Cart();
		cart.setCartId(cartDto.getCartId());
		
		Optional<User> user = userRepository.findByUserName(cartDto.getUserName());
		
		if (user.isEmpty())
			return false;
		
		Optional<Cart> cartDBop = cartRepository.findByUser(user.get());
		if (cartDBop.isPresent()) {
			updateCart(cartDto, cartDBop.get());
		} else { // there should always be 1 cart for a user, create a new cart when creating a new user
			cart.setUser(user.get());
			GroceryList groceryList = new GroceryList(cartDto.getGroceries());
			
			List<Item> items = itemRepository.saveAll(groceryList.getItemsList());
			groceryList.setItemsList(items);
			groceryList = groceryListRepository.save(groceryList);
			
			cart.setGroceries(groceryList);
			
			cartRepository.save(cart);
		}
		return true;
	}
	
	@Override
	public CartDto getCartDetails(String userName) {
		Optional<User> userOp = userRepository.findByUserName(userName);
		CartDto cartDto = new CartDto();
		if (userOp.isPresent()) {
			User user = userOp.get();
			Optional<Cart> cartOp = cartRepository.findByUser(user);
			
			if (cartOp.isPresent()) {
				Cart cart = cartOp.get();
				cartDto.setCartId(cart.getCartId());
				cartDto.setUserName(userName);
				
				GroceryListDto groceryListDto = new GroceryListDto();
				groceryListDto.setListId(cart.getGroceries().getGrocery_id());
				groceryListDto.setItemsList(cart.getGroceries().getItemsList());
				
				cartDto.setGroceries(groceryListDto);
			}
			
		}
		return cartDto;
	}
	
	
	public boolean clearCart(String username){ // should not be able to delete carts only gLists and items
		Optional<User> userOp = userRepository.findByUserName(username);
		if (userOp.isEmpty())
			return false;
		
		User user = userOp.get();
		Optional<Cart> cartOp = cartRepository.findByUser(user);
			
		if (cartOp.isPresent()) {
			Cart cart = cartOp.get();
			GroceryList groceryList = cart.getGroceries();
			Collection<Item> itemDB = groceryList.getItemsList(); // get items
			
			var delItemDto = new DeleteItemDto(); // create item dto
			delItemDto.setUserName(user.getUserName());
			
			List<Item> items = new ArrayList<>();
			for (Item item : itemDB) {
				items.add(item);
			}
			// while deleting you need to delete in acending order
			// and for adding the items you need to follow the reverse
			cartRepository.delete(cart);
			groceryListRepository.delete(groceryList);
			itemRepository.deleteAll(items);
		}
		return true;
	}
	
	
	@Override
	public boolean deleteItems(DeleteItemDto deleteItemDto) {
		Optional<User> userOp = userRepository.findByUserName(deleteItemDto.getUserName());
		if (userOp.isPresent()) {
			User user = userOp.get();
			Optional<Cart> cartOp = cartRepository.findByUser(user);
			
			if (cartOp.isPresent()) {
				Cart cartDB = cartOp.get();
				GroceryList groceryList = cartDB.getGroceries();
				Collection<Item> itemsDB = groceryList.getItemsList();
				
				for (long itemId : deleteItemDto.getItemIds()) { // change to id
					//Item itemToDelete = itemsDB.stream().filter(x -> x.getItemId().equalsIgnoreCase(item)).findAny().orElse(null);
					var item = itemRepository.getById(itemId);
					itemsDB.remove(item);
					groceryList.setItemsList(itemsDB);
					groceryListRepository.save(groceryList);
					itemRepository.delete(item);
				}
				
			}
			
		}
		return true;
	}
	
	
	protected void updateCart(CartDto cartDto, Cart cartDB) {
		
		GroceryList groceryList = cartDB.getGroceries();
		
		Collection<Item> itemsDB = groceryList.getItemsList();
		
		Set<Item> finalItemList = new HashSet<>();
		
		for (Item i : cartDto.getGroceries().getItemsList()) {
			
			Item item = itemsDB.stream().filter(x -> x.getItemName().equalsIgnoreCase(i.getItemName())).findAny().orElse(null);
			
			if (item != null) {
				item.setItemQuantity(i.getItemQuantity() + item.getItemQuantity());
				
				finalItemList.add(itemRepository.save(item));
			} else {
				
				finalItemList.add(itemRepository.save(i));
			}
		}
		
		//itemsDB = (Set<Item>) itemRepository.saveAll(itemsDB);
		groceryList.setItemsList(finalItemList);
		groceryList = groceryListRepository.save(groceryList);
		cartDB.setGroceries(groceryList);
		cartRepository.save(cartDB);
		
	}
}
