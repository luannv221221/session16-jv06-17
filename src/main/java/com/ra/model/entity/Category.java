package com.ra.model.entity;

import com.ra.validate.UniqueCategory;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name",length = 100,unique = true,nullable = false)
    @NotBlank(message = "Vui lòng nhập cái tên vào")
    @UniqueCategory
    private String categoryName;
    @NotBlank(message = "Vui nhập description")
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @ColumnDefault("1")
    private boolean status;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
    public Category() {
    }

    public Category(int id, String categoryName, String description, boolean status, Set<Product> products) {
        this.id = id;
        this.categoryName = categoryName;
        this.description = description;
        this.status = status;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
