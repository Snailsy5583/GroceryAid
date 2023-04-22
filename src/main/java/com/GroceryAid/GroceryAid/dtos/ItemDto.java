package com.GroceryAid.GroceryAid.dtos;

import com.GroceryAid.GroceryAid.entities.Item;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	private Long itemId;
	private Long walmartSKU;
	private float itemPrice;
	private int itemQuantity;
	
	public ItemDto(Item item)
	{
		this.itemId=item.getItemId();
		this.walmartSKU=item.getWalmartSKU();
		this.itemPrice=item.getItemPrice();
		this.itemQuantity=item.getItemQuantity();
	}
}
