package com.ptit.shopshoe.service;

import com.ptit.shopshoe.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> getAll();
}
