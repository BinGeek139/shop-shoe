package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
