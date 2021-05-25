package com.ptit.shopshoe.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Product {
    private Integer idProduct;
    private String name;
    private Double price;
    private Double sale;
    private String image;
    private String description;
    private Boolean status;
    private Timestamp timeIn;
    private String modem;
    private Integer quantity;
    private Integer sold;
    private Integer size;
    private String color;
    List<Order> orders;
    Category category;
    Supplier supplier;
    Gender gender;

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Integer getIdProduct() {
        return idProduct;
    }



    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "sale")
    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "description",columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "time_in")
    public Timestamp getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Timestamp timeIn) {
        this.timeIn = timeIn;
    }

    @Basic
    @Column(name = "modem")
    public String getModem() {
        return modem;
    }

    public void setModem(String modem) {
        this.modem = modem;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "sold")
    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    @Basic
    @Column(name = "size")
    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Basic
    @Column(name = "Color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return idProduct == product.idProduct && Double.compare(product.price, price) == 0 && Double.compare(product.sale, sale) == 0 && status == product.status && sold == product.sold && size == product.size && Objects.equals(name, product.name) && Objects.equals(image, product.image) && Objects.equals(description, product.description) && Objects.equals(timeIn, product.timeIn) && Objects.equals(modem, product.modem) && Objects.equals(quantity, product.quantity) && Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, price, sale, image, description, status, timeIn, modem, quantity, sold, size, color);
    }
    @ManyToOne
    @JoinColumn(name = "id_category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    @ManyToOne
    @JoinColumn(name = "id_supplier" )
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    @ManyToOne
    @JoinColumn(name = "id_gender")
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<Order> getOrders() {
        return orders;
    }

}
