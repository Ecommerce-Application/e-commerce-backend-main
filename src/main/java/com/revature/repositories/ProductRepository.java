package com.revature.repositories;

import com.revature.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<List<Product>> findByDescription(String prodDesc);
    Optional<List<Product>> findByName(String prodName);
    Optional<List<Product>> findByImage(String prodImage);
    Optional<List<Product>> findByPrice(double prodPrice);
}
