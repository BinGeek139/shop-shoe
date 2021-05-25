package com.ptit.shopshoe.service;

import com.ptit.shopshoe.dto.CartDto;

public interface CartService {
    CartDto getByCustomer(Integer customerId);
}
