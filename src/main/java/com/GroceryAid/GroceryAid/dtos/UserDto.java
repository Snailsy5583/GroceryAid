package com.GroceryAid.GroceryAid.dtos;

import com.GroceryAid.GroceryAid.entities.User;
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
	
	public UserDto(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.email = user.getEmail();
	}
}