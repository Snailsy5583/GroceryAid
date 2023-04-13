package com.GroceryAid.GroceryAid.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Groceries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroceryList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column
    private Long listId;
    @Column
    private Long walmartItemSku;
    @Column
    private String itemName;
    @Column
    private float itemPrice;
    @Column
    private int itemQuantity;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonBackReference
    private User user;
}
