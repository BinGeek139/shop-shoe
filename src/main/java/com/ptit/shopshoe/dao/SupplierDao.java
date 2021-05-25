package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierDao  extends JpaRepository<Supplier, Integer> {
}
