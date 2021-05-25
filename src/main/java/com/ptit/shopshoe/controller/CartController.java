package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.dto.CartDto;
import com.ptit.shopshoe.dto.PaymentDto;
import com.ptit.shopshoe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "*")
public class CartController {
    @Autowired
    CartService cartService;
    @GetMapping()
    public ResponseEntity<ResponseData> getByCustomerId(Integer customerId){
        CartDto supplierDto = cartService.getByCustomer(customerId);
        ResponseData responseData=null;
        responseData=ResponseData.ofSuccess(supplierDto);
        return ResponseEntity.ok(responseData);
    }
}
