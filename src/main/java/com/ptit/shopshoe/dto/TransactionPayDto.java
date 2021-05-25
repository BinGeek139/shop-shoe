package com.ptit.shopshoe.dto;

import com.ptit.shopshoe.entity.Cart;
import com.ptit.shopshoe.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TransactionPayDto {
    private int idTransaction;
    private int phone;
    private String customerName;
    private String email;
    private String address;
    private Timestamp time;
    private CartDto cart;
    private PaymentDto payment;
}
