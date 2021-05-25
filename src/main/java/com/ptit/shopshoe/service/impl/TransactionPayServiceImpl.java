package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.controller.request.TransactionRequest;
import com.ptit.shopshoe.dao.CartDao;
import com.ptit.shopshoe.dao.PaymentDao;
import com.ptit.shopshoe.dao.TransactionPayDao;
import com.ptit.shopshoe.dto.TransactionPayDto;
import com.ptit.shopshoe.entity.Cart;
import com.ptit.shopshoe.entity.Payment;
import com.ptit.shopshoe.entity.Transactionpay;
import com.ptit.shopshoe.service.TransactionPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class TransactionPayServiceImpl implements TransactionPayService {
    @Autowired
    TransactionPayDao transactionPayDao;
    @Autowired
    CartDao cartDao;
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    GenericMapper genericMapper;
    @Override
    public TransactionPayDto tranfer(TransactionRequest transactionRequest) {
        Transactionpay transactionpay=new Transactionpay();
        transactionpay.setPhone(transactionRequest.getPhone());
        transactionpay.setCustomerName(transactionRequest.getCustomerName());
        transactionpay.setEmail(transactionRequest.getEmail());
        transactionpay.setAddress(transactionRequest.getAddress());
        transactionpay.setTime(new Timestamp(System.currentTimeMillis()));
        transactionpay.setCart(cartDao.findById(transactionRequest.getIdCart()).orElse(null));
        transactionpay.setPayment(paymentDao.findById(transactionRequest.getIdPayment()).orElse(null));
        Transactionpay save = transactionPayDao.save(transactionpay);
        Cart cart = save.getCart();
        cart.setStatus(true);
        cartDao.save(cart);
        return genericMapper.mapToType(save,TransactionPayDto.class);
    }
}
