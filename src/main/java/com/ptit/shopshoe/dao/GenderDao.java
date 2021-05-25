package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Customer;
import com.ptit.shopshoe.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderDao extends JpaRepository<Gender, Integer> {
}
