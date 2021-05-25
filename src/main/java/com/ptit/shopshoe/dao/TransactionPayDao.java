package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Supplier;
import com.ptit.shopshoe.entity.Transactionpay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionPayDao extends JpaRepository<Transactionpay, Integer> {
}
