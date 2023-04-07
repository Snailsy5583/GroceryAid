package com.GroceryAid.GroceryAid.dtos;

import com.GroceryAid.GroceryAid.entities.GroceryList;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto implements Serializable {
    private Long cartId;
    private Set<GroceryListDto> groceryListDtoSet = new HashSet<>();

//    public BridgeDto(Note note){
//        if (note.getId() != null){
//            this.id = note.getId();
//        }
//        if (note.getBody() != null){
//            this.body = note.getBody();
//        }
}