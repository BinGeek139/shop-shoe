package com.ptit.shopshoe.service;

import com.ptit.shopshoe.controller.request.SupplierRequest;
import com.ptit.shopshoe.dto.SupplierDto;
import com.ptit.shopshoe.dto.SupplierDto;

import java.util.List;

public interface SupplierService {
    SupplierDto getById(Integer id);

    List<SupplierDto> getAll();

    SupplierDto create(SupplierRequest supplierRequest);

    SupplierDto update(Integer id, SupplierRequest supplierRequest);

    Boolean delete(Integer id);
}
