package com.ptit.shopshoe.controller.request;

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
public class TransactionRequest {
    private Integer phone;
    private String customerName;
    private String email;
    private String address;
    private Integer idCart;
    private Integer idPayment;
}
