package com.ptit.shopshoe.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Cart {
    private Integer idCart;
    private Timestamp date;
    List<Order> orders;
    Customer customer;
    Boolean status;
    Transactionpay transactionpay;

    public Cart() {
    }

    public Cart(Timestamp date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    @Id
    @Column(name = "id_cart")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return idCart == cart.idCart && Objects.equals(date, cart.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCart, date);
    }

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @ManyToOne
    @JoinColumn(name = "id_customer")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(name = "status",columnDefinition = "tinyint default 0")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @OneToOne(mappedBy = "cart")
    public Transactionpay getTransactionpay() {
        return transactionpay;
    }

    public void setTransactionpay(Transactionpay transactionpay) {
        this.transactionpay = transactionpay;
    }
}
