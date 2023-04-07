package com.GroceryAid.GroceryAid.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryListDto implements Serializable {
    private Long listId;
    private Long walmartItemSku;
    private String itemName;
    private float itemPrice;
    private int itemQuantity;

    private UserDto userDto;
//
//    public NoteDto(Note note){
//        if (note.getId() != null){
//            this.id = note.getId();
//        }
//        if (note.getBody() != null){
//            this.body = note.getBody();
//        }
}
