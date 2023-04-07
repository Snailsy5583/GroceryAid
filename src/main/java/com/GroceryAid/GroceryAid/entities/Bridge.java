package com.GroceryAid.GroceryAid.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Bridge")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bridge {
    @OneToOne
    private User user;
    @OneToOne
    private Cart cart;

}
