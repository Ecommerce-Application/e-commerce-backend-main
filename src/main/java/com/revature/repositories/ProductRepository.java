package com.revature.repositories;

import com.revature.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("FROM Product WHERE prodDesc LIKE %:prodDesc")
    Optional<List<Product>> findByprodDesc(String prodDesc);
    @Query("FROM Product WHERE prodName LIKE %:prodName")
    Optional<List<Product>> findByProdName(String prodName);
    @Query("FROM Product WHERE prodImage LIKE %:prodImage")
    Optional<List<Product>> findByprodImage(String prodImage);
    @Query("FROM Product Where prodPrice LIKE %:prodPrice")
    Optional<List<Product>> findByprodPrice(double prodPrice);

}
