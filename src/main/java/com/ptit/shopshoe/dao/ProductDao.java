package com.ptit.shopshoe.dao;

import com.ptit.shopshoe.entity.Customer;
import com.ptit.shopshoe.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query("from Product ")
    List<Product> findNewProduct(Integer number, Pageable pageable);
    @Query("from Product p where p.category.idCategory = ?1")
    List<Product> findNewProductForCategoryLimit(Integer idCategory, Pageable pageable);

    @Query("from Product p where p.category.idCategory = ?1")
    List<Product> findNewProductForCategory(Integer idCategory);

    @Query(value = "delete from product p where p.id_product= ?1",nativeQuery = true)
    void deleteByFullProduct(Integer id);

}
