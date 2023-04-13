package com.GroceryAid.GroceryAid.repositories;

import com.GroceryAid.GroceryAid.entities.Cart;
import com.GroceryAid.GroceryAid.entities.GroceryList;
import com.GroceryAid.GroceryAid.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroceryListRepository extends JpaRepository<GroceryList, Long> {
    List<GroceryList> findByUser(User user);

}
