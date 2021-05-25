package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Gender;
import com.ptit.shopshoe.entity.Order;
import com.ptit.shopshoe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {
    @Transactional
    @Modifying
    @Query(value = "delete from order_tb o where o.id_order =  ?1 ",nativeQuery = true)
    void deleteOrId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from order_tb o where o.id_cart =  ?1 ",nativeQuery = true)
    void deleteOrCartId(Integer id);


}
