package com.ptit.shopshoe.controller;

import com.ptit.shopshoe.config.ResponseData;
import com.ptit.shopshoe.controller.request.SupplierRequest;
import com.ptit.shopshoe.dto.SupplierDto;
import com.ptit.shopshoe.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Supplier")
@CrossOrigin(origins = "*")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("{id}")
    public ResponseEntity<ResponseData> getById(@PathVariable("id") Integer id){
        SupplierDto supplierDto = supplierService.getById(id);
        ResponseData responseData=null;
        if(supplierDto != null){
            responseData=ResponseData.ofSuccess(supplierDto);
        }else {
            responseData=ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }
    @GetMapping()
    public ResponseEntity<ResponseData> getAll(){
        List<SupplierDto> supplierDto = supplierService.getAll();
        ResponseData responseData=null;
        if(supplierDto != null){
            responseData=ResponseData.ofSuccess(supplierDto);
        }else {
            responseData=ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody SupplierRequest SupplierRequest){
        SupplierDto SupplierDto = supplierService.create(SupplierRequest);
        ResponseData responseData=null;
        if(SupplierDto != null){
            responseData=ResponseData.ofSuccess(SupplierDto);
        }else {
            responseData=ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseData> update(@PathVariable("id") Integer id,
                                               @RequestBody SupplierRequest SupplierRequest){
        SupplierDto supplierDto = supplierService.update(id,SupplierRequest);
        ResponseData responseData=null;
        if(supplierDto != null){
            responseData=ResponseData.ofSuccess(supplierDto);
        }else {
            responseData=ResponseData.ofFailure();
        }
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseData> delete(@PathVariable("id") Integer id){
        Boolean delete= supplierService.delete(id);
        ResponseData responseData=null;
        if(delete){
            responseData=ResponseData.ofOk();
        }else {
            responseData=ResponseData.ofFailure("Id không tồn tại");
        }
        return ResponseEntity.ok(responseData);
    }
}
