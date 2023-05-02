package com.GroceryAid.GroceryAid.entities;

import com.GroceryAid.GroceryAid.dtos.GroceryListDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
//@Table(name = "Groceries")
//@Table(name = "grocery_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroceryList {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "grocery_id")
	private Long grocery_id;
	
	@OneToMany
	@Column(name = "item_id")
	Collection<Item> itemsList;
	
	/*@ManyToOne
	@JoinColumn(name = "user")
	@JsonBackReference
	private User user;*/// glist should have access to user
	
	public GroceryList(GroceryListDto groceryListDto) {
		this.grocery_id = groceryListDto.getListId();
		this.itemsList = groceryListDto.getItemsList();
//		 this.user = groceryListDto.getUser();
	}
	
	public void setGrocery_id(Long grocery_id) {
		this.grocery_id = grocery_id;
	}
	
	public void setItemsList(Collection<Item> itemsList) {
		this.itemsList = itemsList;
	}
	
	public Collection<Item> getItemsList() {
		return itemsList;
	}
}
