package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Customer;
import com.ptit.shopshoe.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
