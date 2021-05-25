package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.controller.request.SupplierRequest;
import com.ptit.shopshoe.controller.request.TransactionRequest;
import com.ptit.shopshoe.dto.SupplierDto;
import com.ptit.shopshoe.dto.TransactionPayDto;
import com.ptit.shopshoe.service.TransactionPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*")
public class TransactionPayController {
    @Autowired
    TransactionPayService transactionPayService;

    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody TransactionRequest transactionRequest) {
        TransactionPayDto tranfer = transactionPayService.tranfer(transactionRequest);
        return ResponseEntity.ok(ResponseData.ofSuccess(tranfer));
    }

}
