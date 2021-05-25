package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Cart;
import com.ptit.shopshoe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDao extends JpaRepository<Cart, Integer> {
    List<Cart> findByCustomer_IdCustomerAndStatus(Integer idCustomer,Boolean status);
}
