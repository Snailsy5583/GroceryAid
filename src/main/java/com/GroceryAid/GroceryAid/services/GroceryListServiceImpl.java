package com.GroceryAid.GroceryAid.services;

import com.GroceryAid.GroceryAid.dtos.DeleteItemDto;
import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.Item;
import com.GroceryAid.GroceryAid.entities.User;
import com.GroceryAid.GroceryAid.repositories.GroceryListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroceryListServiceImpl implements GroceryListService {
	@Autowired
	GroceryListRepository gLRepo;
	
	@Override
	public void addItem(GroceryListDto gListDto) {
	
	}
	
	@Override
	public void deleteItem(GroceryListDto glistDto, Item item) {
	
	}
	
	@Override
	public void addList(User user) {
		GroceryList glist = new GroceryList();
		//glist.setUser(user);
	}
	
	@Override
	public void deleteList(GroceryListDto gListDto) {
		var gList_op = gLRepo.findById(gListDto.getListId());
		if (gList_op.isEmpty())
			return;

		var gList = gList_op.get();
		var delItemDto = new DeleteItemDto();
//		delItemDto.setItemIds(gList.getItemsList());
		
		
		gLRepo.delete(gList);
	}
}
