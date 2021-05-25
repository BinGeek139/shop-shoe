package com.ptit.shopshoe.service;


import com.ptit.shopshoe.dto.ProductDto;
import com.ptit.shopshoe.controller.request.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ProductDto getById(Integer id);

    List<ProductDto> getAll();
    List<ProductDto> getNewProduct(Integer number);
    List<ProductDto> getNewProductForCategory(Integer idCategory,Integer number);

    ProductDto create(ProductRequest productRequest, MultipartFile multipartFile);

    ProductDto update(Integer id, ProductRequest productRequest);

    Boolean delete(Integer id);

    String updateImage(Integer id,MultipartFile multipartFile);
}
