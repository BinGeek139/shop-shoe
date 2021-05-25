package com.ptit.shopshoe.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Supplier {
    private int idSupplier;
    private String supplierName;
    private String address;
    private String phone;
    private String email;
    private List<Product> products;



    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_supplier")
    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Basic
    @Column(name = "supplier_name",columnDefinition = "char(100)")
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Basic
    @Column(name = "address",columnDefinition = "char(200)")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone",columnDefinition = "char(11)")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email",columnDefinition = "char(50)")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return idSupplier == supplier.idSupplier && Objects.equals(supplierName, supplier.supplierName) && Objects.equals(address, supplier.address) && Objects.equals(phone, supplier.phone) && Objects.equals(email, supplier.email);
    }
    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    @Override
    public int hashCode() {

        return Objects.hash(idSupplier, supplierName, address, phone, email);
    }
}
