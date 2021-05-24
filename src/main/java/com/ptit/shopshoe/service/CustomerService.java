package com.ptit.shopshoe.service;

import com.ptit.shopshoe.controller.request.LoginRequest;
import com.ptit.shopshoe.controller.request.RegisterRequest;
import com.ptit.shopshoe.controller.response.LoginResponse;

public interface CustomerService {
    LoginResponse login(LoginRequest loginRequest);
    Boolean register(RegisterRequest registerRequest);

}
