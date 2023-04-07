package com.GroceryAid.GroceryAid.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long userId;
    private String userName;
    private String password;
    private String email;
    private Set<GroceryListDto> groceryListDtoSet = new HashSet<>();
//
//    public NoteDto(Note note){
//        if (note.getId() != null){
//            this.id = note.getId();
//        }
//        if (note.getBody() != null){
//            this.body = note.getBody();
//        }
    }
