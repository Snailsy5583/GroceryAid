package com.GroceryAid.GroceryAid.entities;

import com.GroceryAid.GroceryAid.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column
    private String userName;
    @Column
    private String password;
    @Column(unique = true, nullable = true)
    private String email;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<GroceryList> groceryListSet = new HashSet<>();
    
   /* @OneToOne
    @JoinTable(
        name = "Bridge",
        joinColumns = @JoinColumn(name = "userId"),
        inverseJoinColumns = @JoinColumn(name = "cartId")
    )
    private Cart cart;*/

   
    public User(UserDto userDto)
    {
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
    }
    public GroceryList createGroceryList()
    {
        GroceryList groceryList = new GroceryList();
        
        return null;
    }

}
