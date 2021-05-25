package com.ptit.shopshoe.service.impl;

import com.ptit.shopshoe.config.GenericMapper;
import com.ptit.shopshoe.controller.request.OrderRequest;
import com.ptit.shopshoe.dao.CartDao;
import com.ptit.shopshoe.dao.CustomerDao;
import com.ptit.shopshoe.dao.OrderDao;
import com.ptit.shopshoe.dao.ProductDao;
import com.ptit.shopshoe.dto.CartDto;
import com.ptit.shopshoe.entity.Cart;
import com.ptit.shopshoe.entity.Order;
import com.ptit.shopshoe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    CartDao cartDao;
    @Autowired
    CustomerDao customerDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    GenericMapper genericMapper;

    @Transactional
    @Override
    public CartDto create(OrderRequest orderRequest) throws Exception {
        var carts = cartDao.findByCustomer_IdCustomerAndStatus(orderRequest.getCustomerId(),false);
        Cart cart;
        if (carts.size() == 0) {
            cart = new Cart(Timestamp.from(Instant.now()), customerDao.findById(orderRequest.getCustomerId()).orElse(null));
            cart.setStatus(Boolean.FALSE);
            cart = cartDao.save(cart);
            Order order = new Order();
            order.setCart(cart);
            order.setProduct(productDao.findById(orderRequest.getProductId()).orElse(null));
            if(order.getProduct().getQuantity() < orderRequest.getAmount().intValue()){
                throw new Exception("Số lượng mặt hàng trong kho không đủ");
            }
            order.setAmount(orderRequest.getAmount());
            order.setCart(cart);
            orderDao.save(order);
            cart=cartDao.findById(cart.getIdCart()).orElse(null);

        } else {
            cart = carts.get(0);
            Boolean check = true;
            for (Order order : cart.getOrders()) {
                if (order.getProduct().getIdProduct().equals(orderRequest.getProductId())) {
                    order.setAmount(order.getAmount().add(orderRequest.getAmount()));
                    if(order.getProduct().getQuantity() < order.getAmount().intValue()){
                        throw new Exception("Số lượng mặt hàng trong kho không đủ");
                    }
                    check = false;
                    break;
                }
            }
            if (check) {
                Order order = new Order();
                order.setCart(cart);
                order.setProduct(productDao.findById(orderRequest.getProductId()).orElse(null));
                if(order.getProduct().getQuantity() < orderRequest.getAmount().intValue()){
                    throw new Exception("Số lượng mặt hàng trong kho không đủ");
                }
                order.setAmount(orderRequest.getAmount());
                order.setCart(cart);
                orderDao.save(order);
                cart=cartDao.findById(cart.getIdCart()).orElse(null);
            }else {
                cart= cartDao.save(cart);
            }
        }

        return genericMapper.mapToType(cart, CartDto.class);
    }

    @Override
    public Boolean delete(Integer integer) {
        orderDao.deleteOrId(integer);
        return true;
    }

    @Override
    public Boolean deleteByCartId(Integer integer) {
        orderDao.deleteOrCartId(integer);
        return true;
    }
}
