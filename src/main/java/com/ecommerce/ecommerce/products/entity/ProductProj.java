package com.ecommerce.ecommerce.products.entity;
import com.ecommerce.ecommerce.category.model.Category;
import com.ecommerce.ecommerce.users.Entity.User;

public interface ProductProj {

     Long getId();
     String getImage();
     String getName();
     boolean available();
     Double getPrice();
     String getDiscount();
     String getBrand();
     Category getCategory();
     String getDescripton();
     Float getQuantity();
     String getSellunit();
     User getSeller(); 
}
