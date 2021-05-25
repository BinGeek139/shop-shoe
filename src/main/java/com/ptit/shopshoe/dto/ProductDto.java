package com.ptit.shopshoe.dto;

import com.ptit.shopshoe.entity.Category;
import com.ptit.shopshoe.entity.Gender;
import com.ptit.shopshoe.entity.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ProductDto {
    private Integer idProduct;
    private String name;
    private Double price;
    private Double sale;
    private String image;
    private String description;
    private Boolean status;
    private String modem;
    private Integer quantity;
    private Integer sold;
    private Integer size;
    private String color;
    CategoryDto category;
    SupplierDto supplier;
    GenderDto gender;
}
