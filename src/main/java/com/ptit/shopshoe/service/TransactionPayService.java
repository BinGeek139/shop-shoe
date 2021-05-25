package com.ptit.shopshoe.service;

import com.ptit.shopshoe.controller.request.TransactionRequest;
import com.ptit.shopshoe.dto.TransactionPayDto;

public interface TransactionPayService {
    TransactionPayDto tranfer(TransactionRequest transactionRequest);
}
