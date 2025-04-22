package com.ecommerce.ecommerce.products.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.products.entity.Product;
import com.ecommerce.ecommerce.products.entity.ProductProj;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>{

    List<Product> findAllByCategory_id(Long category);
  

    @Query("SELECT p FROM Product p " +
    "WHERE (:term IS NULL OR LOWER(p.name) LIKE CONCAT('%', LOWER(:term), '%')) " +
    "AND (:categoryId IS NULL OR p.category.id = :categoryId ) " +
    "AND (:location IS NULL OR LOWER(p.seller.locality) LIKE CONCAT('%', LOWER(:location), '%')) " +
    "AND (:price IS NULL OR p.price BETWEEN 0 AND :price)")
List<ProductProj> filterProduct(String term, Double price,Long categoryId,String location);
    // List<Product> findAllByStore_place(String place);
    Optional<Product> findAllBySeller_idAndNameContainingIgnoreCase(Long id, String name);
    List<Product> findAllBySeller_id(Long id);

    // List<Product> findAllByStore_user_id(Long id);


    
}
