package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.controller.request.CategoryRequest;
import com.ptit.shopshoe.controller.request.LoginRequest;
import com.ptit.shopshoe.controller.response.LoginResponse;
import com.ptit.shopshoe.dto.CategoryDto;
import com.ptit.shopshoe.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("{id}")
    public ResponseEntity<ResponseData> getById(@PathVariable("id") Integer id){
        CategoryDto categoryDto = categoryService.getById(id);
        ResponseData responseData=null;
        if(categoryDto != null){
            responseData=ResponseData.ofSuccess(categoryDto);
        }else {
            responseData=ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }
    @GetMapping()
    public ResponseEntity<ResponseData> getAll(){
        List<CategoryDto> categoryDto = categoryService.getAll();
        ResponseData responseData=null;
        if(categoryDto != null){
            responseData=ResponseData.ofSuccess(categoryDto);
        }else {
            responseData=ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody CategoryRequest categoryRequest){
        CategoryDto categoryDto = categoryService.create(categoryRequest);
        ResponseData responseData=null;
        if(categoryDto != null){
            responseData=ResponseData.ofSuccess(categoryDto);
        }else {
            responseData=ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseData> update(@PathVariable("id") Integer id,
                                               @RequestBody CategoryRequest categoryRequest){
        CategoryDto categoryDto = categoryService.update(id,categoryRequest);
        ResponseData responseData=null;
        if(categoryDto != null){
            responseData=ResponseData.ofSuccess(categoryDto);
        }else {
            responseData=ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<ResponseData> delete(@PathVariable("id") Integer id){
        Boolean delete= categoryService.delete(id);
        ResponseData responseData=null;
        if(delete){
            responseData=ResponseData.ofOk();
        }else {
            responseData=ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }

}
