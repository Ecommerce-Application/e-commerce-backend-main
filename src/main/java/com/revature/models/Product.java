package com.revature.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
