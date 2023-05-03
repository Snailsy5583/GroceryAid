package com.GroceryAid.GroceryAid.dtos;

import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.Item;
import com.GroceryAid.GroceryAid.entities.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryListDto implements Serializable {
    private Long listId;
    Collection<Item> itemsList;
    private User user;
    
    public GroceryListDto(GroceryList gList)
    {
        this.listId = gList.getGrocery_id();
        this.itemsList = gList.getItemsList();
      //  this.user = gList.getUser();
    }
}
