package com.revature.controllers;

import com.revature.annotations.Authorized;
import com.revature.dtos.ProductInfo;
import com.revature.models.Product;
import com.revature.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prod")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true")
public class ProductController {

    private final ProductService prodService;

    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }

//    @Authorized
    @GetMapping
    public ResponseEntity<List<Product>> getInventory() {
        return ResponseEntity.ok(prodService.findAll());
    }

//    @Authorized
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
        Optional<Product> optional = prodService.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optional.get());
    }

//    @Authorized
    @PutMapping
    public ResponseEntity<Product> upsertProduct(@RequestBody Product prod) {
        return ResponseEntity.ok(prodService.save(prod));
    }

//    @Authorized
    @PatchMapping
    public ResponseEntity<List<Product>> purchaseProduct(@RequestBody List<ProductInfo> metadata) {
        List<Product> prodList = new ArrayList<Product>();

        for (int i = 0; i < metadata.size(); i++) {
            Optional<Product> optional = prodService.findById(metadata.get(i).getId());

            if (!optional.isPresent()) {
                return ResponseEntity.notFound().build();
            }

            Product prod = optional.get();

            if (prod.getProdQuantity() - metadata.get(i).getQuantity() < 0) {
                return ResponseEntity.badRequest().build();
            }

            prod.setProdQuantity(prod.getProdQuantity() - metadata.get(i).getQuantity());
            prodList.add(prod);
        }

        prodService.saveAll(prodList, metadata);

        return ResponseEntity.ok(prodList);
    }

//    @Authorized
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        Optional<Product> optional = prodService.findById(id);

        if (!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        prodService.delete(id);

        return ResponseEntity.ok(optional.get());
    }

//    @Authorized
    @GetMapping("/search")
    public ResponseEntity<?> polyProductSearch(
            @RequestParam(required = false, name = "descQuery") final String descQuery,
            @RequestParam(required = false, name = "nameQuery") final String nameQuery,
            @RequestParam(required = false, name = "imageQuery") final String imageQuery,
            @RequestParam(required = false, name = "priceQuery") final String priceQuery
    ) {

        if (descQuery != null) {
            Optional<List<Product>> taggedProducts = prodService.findByDescription(descQuery);
            if(!taggedProducts.isPresent()) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(taggedProducts.get());

        } else if (nameQuery != null) {
            Optional<List<Product>> namedProducts = prodService.findByName(nameQuery);
            if(!namedProducts.isPresent()) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(namedProducts.get());

        } else if (imageQuery != null) {
            Optional<List<Product>> imagedProducts = prodService.findByImage(imageQuery);
            if(!imagedProducts.isPresent()) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(imagedProducts.get());

        } else if (priceQuery != null) {
            //todo validation check for priceQuery, what does the DTO actually trasmit
            double locPriceQuery = Double.parseDouble(priceQuery);
            Optional<List<Product>> pricedProducts = (prodService.findByPrice(locPriceQuery));
            if(!pricedProducts.isPresent()) return ResponseEntity.notFound().build();
            return ResponseEntity.ok(pricedProducts.get());
        }
        return null;
    }
}
