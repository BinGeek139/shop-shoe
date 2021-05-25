package com.ptit.shopshoe.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
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
    Integer idCategory;
    Integer idSupplier;
    Integer idGender;
}
