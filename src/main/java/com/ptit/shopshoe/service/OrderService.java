package com.ptit.shopshoe.service;

import com.ptit.shopshoe.controller.request.OrderRequest;
import com.ptit.shopshoe.dto.CartDto;
import com.ptit.shopshoe.dto.OrderDto;

public interface OrderService {
    CartDto create(OrderRequest orderRequest) throws Exception;
    Boolean delete(Integer integer);
    Boolean deleteByCartId(Integer integer);
}
