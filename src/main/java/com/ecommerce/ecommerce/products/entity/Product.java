package com.ecommerce.ecommerce.products.entity;

import com.ecommerce.ecommerce.category.model.Category;
import com.ecommerce.ecommerce.users.Entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
    private String name;
    private Double price;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private String descripton;
    private Float quantity;
    private String sellunit;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    public Product(ProductDTO product) {
        this.id = product.getId();
        this.image = product.getImage();
        this.name = product.getName();
        this.price = product.getPrice();
        this.category = product.getCategory();
        this.descripton = product.getDescripton();
        this.sellunit = product.getSellunit();
    }

}
