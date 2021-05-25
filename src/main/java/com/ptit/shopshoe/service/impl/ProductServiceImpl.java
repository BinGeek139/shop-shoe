package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.dao.ProductDao;
import com.ptit.shopshoe.dto.ProductDto;
import com.ptit.shopshoe.entity.Product;
import com.ptit.shopshoe.entity.Supplier;
import com.ptit.shopshoe.service.ProductService;
import com.ptit.shopshoe.controller.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    GenericMapper genericMapper;

    @Autowired
    ProductDao productDao;

    @Override
    public ProductDto getById(Integer id) {
        Optional<Product> optionalProduct = productDao.findById(id);
        if(optionalProduct.isPresent()){
            return genericMapper.mapToType(optionalProduct.get(),ProductDto.class);
        }
        return null;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Product> all = productDao.findAll();
        return genericMapper.mapToListOfType(all,ProductDto.class);

    }

    @Override
    public Boolean delete(Integer id) {
        Product supplier= productDao.findById(id).orElse(null);
        if (supplier ==null) {
            return false;
        }
        productDao.delete(supplier);
        return true;

    }

    @Override
    public ProductDto update(Integer id, ProductRequest productRequest) {
        return null;
    }

    @Override
    public ProductDto create(ProductRequest productRequest, MultipartFile multipartFile) {
        return null;
    }
}
