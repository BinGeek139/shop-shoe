package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.controller.request.OrderRequest;
import com.ptit.shopshoe.dto.CartDto;
import com.ptit.shopshoe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody OrderRequest orderRequest) throws Exception {
        CartDto cartDto = orderService.create(orderRequest);
        return ResponseEntity.ok(ResponseData.ofSuccess(cartDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseData> delete(@PathVariable("id") Integer id){
        Boolean aBoolean= orderService.delete(id);
        ResponseData responseData = null;
        if (aBoolean) {
            responseData = ResponseData.ofOk();
        } else {
            responseData = ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }
    @DeleteMapping("cart/{id}")
    public ResponseEntity<ResponseData> deleteByIdcCart(@PathVariable("id") Integer id){
        Boolean aBoolean= orderService.deleteByCartId(id);
        ResponseData responseData = null;
        if (aBoolean) {
            responseData = ResponseData.ofOk();
        } else {
            responseData = ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }


}
