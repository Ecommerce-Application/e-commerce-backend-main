package com.revature.repositories;

import com.revature.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Uses pattern matching to find products based on keywords in the description
    // field
    @Query("FROM Product WHERE prodDesc LIKE %:prodDesc%")
//<<<<<<< Updated upstream
    Optional<List<Product>> findByprodDesc(@Param(value = "prodDesc") String prodDesc);

    //@Query("FROM Product WHERE prodName LIKE %:prodName%")
    //Optional<List<Product>> findByprodName(@Param(value = "prodName") String prodName);

    //@Query("FROM Product WHERE prodImage LIKE %:prodImage%")
    //Optional<List<Product>> findByprodImage(@Param(value = "prodImage") String prodImage);

//=======
    //Optional<List<Product>> findByprodDesc(String prodDesc);
    //Uses pattern matching to find products based on partial character matches in name field
    @Query("FROM Product WHERE prodName LIKE %:prodName%")
    List<Product> findByprodName(@Param(value = "prodName") String prodName);

    @Query("FROM Product WHERE prodImage LIKE %:prodImage%")
    Optional<List<Product>> findByprodImage(@Param(value = "prodImage") String prodImage);

    Optional<List<Product>> findByprodPrice(double prodPrice);
    @Query("FROM Product WHERE prodPrice BETWEEN :priceMin AND :priceMax")
    Optional<List<Product>> findByprodPrice(@Param(value = "priceMin") double priceMin, @Param(value = "priceMax") double priceMax);
}
