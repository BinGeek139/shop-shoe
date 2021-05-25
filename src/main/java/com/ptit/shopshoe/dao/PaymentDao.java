package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Order;
import com.ptit.shopshoe.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao  extends JpaRepository<Payment, Integer> {
}
