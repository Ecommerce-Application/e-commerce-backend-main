package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    // Explicit constructor
    public Product(int prodQuantity, double prodPrice, String prodDesc, String prodImage, String prodName) {
        this.prodQuantity = prodQuantity;
        this.prodPrice = prodPrice;
        this.prodDesc = prodDesc;
        this.prodImage = prodImage;
        this.prodName = prodName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private int prodQuantity;
    private double prodPrice;
    private String prodDesc;
    private String prodImage;
    private String prodName;

    @OneToMany(mappedBy = "productId")
    @JsonIgnore
    private List<OrderQuantityBought> quantityBoughts;
}
