package com.ptit.shopshoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CustomerDto {
    private Integer idCustomer;
    private String name;
    private String birthday;
    private String phone;
    private String email;
    private String password;
    private String address;
}
