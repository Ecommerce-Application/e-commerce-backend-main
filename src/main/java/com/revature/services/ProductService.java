package com.revature.services;

import com.revature.dtos.ProductDTO;
import com.revature.models.Product;
import com.revature.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    // Special requests, new stuff
    // For loose-matched search function

//<<<<<<< Updated upstream
//    public Optional<List<Product>> findByName(String prodName) {
//        prodName = prodName.substring(0, 1).toUpperCase() + prodName.substring(1).toLowerCase();
//        return productRepository.findByprodName(prodName);
//    }
//=======
    //Calls the user-defined findByprodName method defined in the product repository layer
    public Optional<List<Product>> findByName(String name) {
        return productRepository.findByprodName(name);
//>>>>>>> Stashed changes
    }

    // Calls the user-defined findByprodDesc method defined in the product
    // repository layer
    public Optional<List<Product>> findByDescription(String descQuery) {
        return productRepository.findByprodDesc(descQuery);
    }

    // Calls the user-defined findByprodImage method defined in the product
    // repository layer
    public Optional<List<Product>> findByImage(String imageQuery) {
        return productRepository.findByprodImage(imageQuery);
    }

    // Calls the user-defined findByprodPrice method defined in the product
    // repository layer
    public Optional<List<Product>> findByPrice(double priceQuery) {
        return productRepository.findByprodPrice(priceQuery);
    }
}