package com.ptit.shopshoe.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RegisterRequest {
    private String name;
    private String birthday;
    private String phone;
    private String email;
    private String password;
    private String address;
}
