package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.controller.request.LoginRequest;
import com.ptit.shopshoe.controller.request.RegisterRequest;
import com.ptit.shopshoe.controller.response.LoginResponse;
import com.ptit.shopshoe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/athor")
@CrossOrigin(origins = "*")
public class AccountController {
    @Autowired
    CustomerService customerService;

    @PostMapping("login")
    public ResponseEntity<ResponseData> login(@RequestBody LoginRequest loginRequest){
        ResponseData responseData=null;
        LoginResponse login = customerService.login(loginRequest);
        if(login != null){
            responseData=ResponseData.ofSuccess(login);
        }else {
            responseData=ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @PostMapping("register")
    public ResponseEntity<ResponseData> register(@RequestBody RegisterRequest registerRequest){

        ResponseData responseData=null;
        if(customerService.register(registerRequest)){
            responseData=ResponseData.ofOk();
        }else {
            responseData=new ResponseData().setCode("1").setMessage("email đã tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }
}
