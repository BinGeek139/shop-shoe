package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Customer;
import com.ptit.shopshoe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
