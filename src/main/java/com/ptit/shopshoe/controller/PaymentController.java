package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.dto.PaymentDto;
import com.ptit.shopshoe.dto.SupplierDto;
import com.ptit.shopshoe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping()
    public ResponseEntity<ResponseData> getAll(){
        List<PaymentDto> supplierDto = paymentService.getAll();
        ResponseData responseData=null;
        responseData=ResponseData.ofSuccess(supplierDto);
        return ResponseEntity.ok(responseData);
    }
}
