package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
=======
import javax.persistence.*;
import java.util.List;
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int prodId;
    private int prodQuantity;
    private double prodPrice;
    private String prodDesc;
    private String prodImage;
    private String prodName;

    @OneToMany(mappedBy = "productId")
=======
    private int id;
    private int quantity;
    private double price;
    private String description;
    private String image;
    private String name;

    @OneToMany(mappedBy = "product_id")
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
    private List<OrderQuantityBought> quantityBoughts;
}
