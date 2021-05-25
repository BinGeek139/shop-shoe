package com.ptit.shopshoe.dto;

import com.ptit.shopshoe.entity.Customer;
import com.ptit.shopshoe.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CartDto {
    private Integer idCart;
    List<OrderDto> orders;
    CustomerDto customer;
}
