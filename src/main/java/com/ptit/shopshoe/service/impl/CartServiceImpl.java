package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.dao.CartDao;
import com.ptit.shopshoe.dto.CartDto;
import com.ptit.shopshoe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;
    @Autowired
    GenericMapper genericMapper;
    @Override
    public CartDto getByCustomer(Integer customerId) {
        return genericMapper.mapToType(cartDao.findByCustomer_IdCustomerAndStatus(customerId,Boolean.FALSE).get(0),CartDto.class); }
}
