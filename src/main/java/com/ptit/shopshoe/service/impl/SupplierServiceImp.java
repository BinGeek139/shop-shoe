package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.controller.request.SupplierRequest;
import com.ptit.shopshoe.dao.CustomerDao;
import com.ptit.shopshoe.dao.SupplierDao;
import com.ptit.shopshoe.dto.SupplierDto;
import com.ptit.shopshoe.entity.Supplier;
import com.ptit.shopshoe.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SupplierServiceImp implements SupplierService {
    @Autowired
    SupplierDao supplierDao;

    @Autowired
    GenericMapper genericMapper;

    @Override
    public SupplierDto getById(Integer id) {
        Supplier Supplier = supplierDao.findById(id).orElse(null);
        return Objects.isNull(Supplier) ? null : genericMapper.mapToType(Supplier, SupplierDto.class);
    }

    @Override
    public List<SupplierDto> getAll() {
        List<Supplier> SupplierDaoAll = supplierDao.findAll();
        return genericMapper.mapToListOfType(SupplierDaoAll, SupplierDto.class);
    }

    @Override
    public SupplierDto create(SupplierRequest SupplierRequest) {
        Supplier save = supplierDao.save(genericMapper.mapToType(SupplierRequest, Supplier.class));
        return genericMapper.mapToType(save, SupplierDto.class);
    }

    @Override
    public SupplierDto update(Integer id, SupplierRequest SupplierRequest) {
        Supplier Supplier = genericMapper.mapToType(SupplierRequest, Supplier.class);
        Supplier.setIdSupplier(id);
        Supplier = supplierDao.save(Supplier);
        return genericMapper.mapToType(Supplier, SupplierDto.class);
    }

    @Override
    public Boolean delete(Integer id) {
       Supplier supplier= supplierDao.findById(id).orElse(null);
        if (supplier ==null) {
            return false;
        }
        supplierDao.delete(supplier);
        return true;
    }
}
