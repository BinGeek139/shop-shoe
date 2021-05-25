package com.ptit.shopshoe.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Transactionpay {
    private Integer idTransaction;
    private Integer phone;
    private String customerName;
    private String email;
    private String address;
    private Timestamp time;
    private Cart cart;
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "id_payment")
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Id
    @Column(name = "id_transaction")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Integer idTransaction) {
        this.idTransaction = idTransaction;
    }



    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactionpay that = (Transactionpay) o;
        return idTransaction == that.idTransaction && phone == that.phone && Objects.equals(customerName, that.customerName) && Objects.equals(email, that.email) && Objects.equals(address, that.address) && Objects.equals(time, that.time);
    }
    @OneToOne
    @JoinColumn(name = "id_cart")
    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaction,  phone, customerName, email, address, time);
    }
}
