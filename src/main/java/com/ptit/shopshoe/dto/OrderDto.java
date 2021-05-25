package com.ptit.shopshoe.dto;

import com.ptit.shopshoe.entity.Cart;
import com.ptit.shopshoe.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderDto {
    private Integer idOrder;
    private BigDecimal amount;
    ProductDto product;
}
