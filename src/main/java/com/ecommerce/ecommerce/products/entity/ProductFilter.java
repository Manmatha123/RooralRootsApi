package com.ecommerce.ecommerce.products.entity;

import com.ecommerce.ecommerce.category.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilter {

    private String name;
    private Category category;
    private String location;
    private Double price;
      
}