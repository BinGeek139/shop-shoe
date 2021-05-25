package com.ptit.shopshoe.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Gender {
    private int idGender;
    private String genderName;

    List<Product> products;
    @Id
    @Column(name = "id_gender")
    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    @Basic
    @Column(name = "gender_name")
    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender gender = (Gender) o;
        return idGender == gender.idGender && Objects.equals(genderName, gender.genderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGender, genderName);
    }
    @OneToMany(mappedBy = "gender",cascade = CascadeType.ALL)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
