package com.ptit.shopshoe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_role")
    private Integer id;

    @Column(name = "name")
    String name;

    @OneToMany(mappedBy = "role")
    List<Customer> customer;

    public Role(Integer idCustomer, String name, List<Customer> customer) {
        this.id = idCustomer;
        this.name = name;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
