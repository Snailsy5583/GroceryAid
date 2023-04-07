package com.GroceryAid.GroceryAid.dtos;

import com.GroceryAid.GroceryAid.entities.Cart;
import com.GroceryAid.GroceryAid.entities.User;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BridgeDto implements Serializable {
    private UserDto userDto;
    private CartDto cartDto;

//    public BridgeDto(Note note){
//        if (note.getId() != null){
//            this.id = note.getId();
//        }
//        if (note.getBody() != null){
//            this.body = note.getBody();
//        }
    }