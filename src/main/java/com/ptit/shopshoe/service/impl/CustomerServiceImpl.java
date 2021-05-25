package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.controller.request.LoginRequest;
import com.ptit.shopshoe.controller.request.RegisterRequest;
import com.ptit.shopshoe.controller.response.LoginResponse;
import com.ptit.shopshoe.dao.CustomerDao;
import com.ptit.shopshoe.dao.RoleDao;
import com.ptit.shopshoe.entity.Customer;
import com.ptit.shopshoe.entity.Role;
import com.ptit.shopshoe.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Autowired
    GenericMapper genericMapper;

    @Transactional
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        List<Customer> customers = customerDao.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if(customers.size() >0){
            return new LoginResponse().setName(customers.get(0).getName()).setRole(String.valueOf(customers.get(0).getRole().getId()));
        }else {
            return null;
        }
    }
    @Autowired
    RoleDao roleDao;

    @Override
    public Boolean register(RegisterRequest registerRequest) {
        if(customerDao.findByEmail(registerRequest.getEmail()).size() > 0){
            return false;
        }

        Customer customer = genericMapper.mapToTypeNotNullProperty(registerRequest, Customer.class);
        customer.setRole( roleDao.findById(1).orElse(null));
        customerDao.save(customer);
        return true;
    }

}
