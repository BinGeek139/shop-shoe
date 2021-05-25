package com.ptit.shopshoe.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Payment {
    private Integer idPayment;
    private String payment;
    List<Transactionpay> transactionpay;

    @OneToMany(mappedBy = "payment")
    public List<Transactionpay> getTransactionpay() {
        return transactionpay;
    }

    public void setTransactionpay(List<Transactionpay> transactionpay) {
        this.transactionpay = transactionpay;
    }

    @Id
    @Column(name = "id_payment")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    @Basic
    @Column(name = "payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment1 = (Payment) o;
        return idPayment == payment1.idPayment && Objects.equals(payment, payment1.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPayment, payment);
    }
}
