package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
    List<Customer> findByEmailAndPassword(String email, String password);
    List<Customer> findByEmail(String email);
}
