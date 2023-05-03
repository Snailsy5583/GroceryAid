package com.GroceryAid.GroceryAid.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToOne
  //  @JoinColumn(name = "grocery_id")
    //private Set<GroceryList> groceryListSet = new HashSet<>();
    private GroceryList groceries = new GroceryList();

   // @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    /*@JoinTable(
        name = "Bridge",
        joinColumns = @JoinColumn(name = "cartId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )*/
   @OneToOne
   @JoinColumn(name = "userId")
    private User user;
}
