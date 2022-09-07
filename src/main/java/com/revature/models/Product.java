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

    private int id;
    private int quantity;
    private double price;
    private String description;
    private String image;
    private String name;

    @OneToMany(mappedBy = "productId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<OrderQuantityBought> quantityBoughts;
}
