package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

<<<<<<< HEAD
import javax.persistence.*;
=======
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
>>>>>>> a4d472441f60ffe298410be441c00293285ad453

@Entity
<<<<<<< HEAD
@Table(name="products")
@Getter
@Setter
=======
@Table(name = "products")
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "prod_id")
public class Product {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int prod_id;

    @Column
=======
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
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
    private String description;

    @Column
    private String image;
<<<<<<< HEAD

    @Column
    private String prod_name;


=======
    private String name;

    @OneToMany(mappedBy = "product_id")
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
    private List<OrderQuantityBought> quantityBoughts;
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
}
