package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.dao.PaymentDao;
import com.ptit.shopshoe.dao.ProductDao;
import com.ptit.shopshoe.dto.PaymentDto;
import com.ptit.shopshoe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;
    @Autowired
    GenericMapper genericMapper;
    @Override
    public List<PaymentDto> getAll() {
        return  genericMapper.mapToListOfType(paymentDao.findAll(),PaymentDto.class);
    }
}
