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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToMany
    @JoinColumn(name = "cartId")
    private Set<GroceryList> groceryListSet = new HashSet<>();

    @OneToOne
    @JoinTable(
        name = "Bridge",
        joinColumns = @JoinColumn(name = "cartId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private User user;
}
