package com.ptit.shopshoe.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "order_tb")
public class Order {
    private Integer idOrder;
    private BigDecimal amount;
    Product product;
    Cart cart;

    @Id
    @Column(name = "id_order")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }


    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return idOrder == order.idOrder && Objects.equals(amount, order.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, amount);
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "id_cart")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
