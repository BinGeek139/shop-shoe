package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.controller.request.CategoryRequest;
import com.ptit.shopshoe.dto.CategoryDto;
import com.ptit.shopshoe.dto.ProductDto;
import com.ptit.shopshoe.dto.SupplierDto;
import com.ptit.shopshoe.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ptit.shopshoe.controller.request.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<ResponseData> getById(@PathVariable("id") Integer id) {
        ProductDto productDto = productService.getById(id);
        ResponseData responseData = null;
        if (productDto != null) {
            responseData = ResponseData.ofSuccess(productDto);
        } else {
            responseData = ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData> delete(@PathVariable("id") Integer id) {
        Boolean delete = productService.delete(id);
        ResponseData responseData = null;
        if (delete) {
            responseData = ResponseData.ofOk();
        } else {
            responseData = ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }

    @GetMapping()
    public ResponseEntity<ResponseData> getAll() {
        List<ProductDto> categoryDto = productService.getAll();
        ResponseData responseData = null;
        if (categoryDto != null) {
            responseData = ResponseData.ofSuccess(categoryDto);
        } else {
            responseData = ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("new-product/{numberProduct}")
    public ResponseEntity<ResponseData> getNewProduct(@PathVariable("numberProduct") Integer numberProduct) {
        List<ProductDto> categoryDto = productService.getNewProduct(numberProduct);
        ResponseData responseData = null;
        if (categoryDto != null) {
            responseData = ResponseData.ofSuccess(categoryDto);
        } else {
            responseData = ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @GetMapping("category")
    public ResponseEntity<ResponseData> getNewProduct(Integer idCategory,Integer numberProduct) {
        List<ProductDto> categoryDto = productService.getNewProductForCategory(idCategory,numberProduct);
        ResponseData responseData = null;
        if (categoryDto != null) {
            responseData = ResponseData.ofSuccess(categoryDto);
        } else {
            responseData = ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }


    @PostMapping
    public ResponseEntity<ResponseData> create(ProductRequest productRequest, MultipartFile image) {
        ProductDto categoryDto = productService.create(productRequest, image);
        ResponseData responseData = null;
        if (categoryDto != null) {
            responseData = ResponseData.ofSuccess(categoryDto);
        } else {
            responseData = ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseData> update(@PathVariable("id") Integer id, ProductRequest productRequest) {
        ProductDto categoryDto = productService.update(id, productRequest);
        ResponseData responseData = null;
        if (categoryDto != null) {
            responseData = ResponseData.ofSuccess(categoryDto);
        } else {
            responseData = ResponseData.ofFailure("Sản phẩm không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("image/{idProduct}")
    public ResponseEntity<ResponseData> updateImage(@PathVariable("idProduct") Integer id, MultipartFile image) {
        String url = productService.updateImage(id, image);
        ResponseData responseData = null;
        if (url != null) {
            responseData = ResponseData.ofSuccess(url);
        } else {
            responseData = ResponseData.ofFailure("Sản phẩm không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }



}
