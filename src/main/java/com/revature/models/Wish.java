package com.revature.models;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
=======
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "wishes")
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
@NoArgsConstructor
@AllArgsConstructor
public class Wish {

    @EmbeddedId
    WishKey id;

    @ManyToOne
<<<<<<< HEAD
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
=======
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User userId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product productId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishId;

    // private String groupId;
    // private String groupName;
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
}
