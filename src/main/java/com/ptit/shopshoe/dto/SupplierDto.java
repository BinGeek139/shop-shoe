package com.ptit.shopshoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SupplierDto {
    private int idSupplier;
    private String supplierName;
    private String address;
    private String phone;
    private String email;
}
