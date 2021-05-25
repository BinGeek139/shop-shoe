package com.ptit.shopshoe.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductRequest {
    private String name;
    private Double price;
    private Double sale;
    private String description;
    private Boolean status;
    private String modem;
    private Integer quantity;
    private Integer sold;
    private Integer size;
    private String color;
    private Integer idCategory;
    private Integer idSupplier;
    private Integer idGender;
}
