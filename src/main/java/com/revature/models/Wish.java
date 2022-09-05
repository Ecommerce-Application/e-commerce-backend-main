package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Wish {

    @EmbeddedId
    WishKey id;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name="user_id")
    private User user_id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="Product_id")
    private Product product_id;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int whish_id;
}
