package com.revature.models;

<<<<<<< HEAD
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Order_Quantities_Bought")
@NoArgsConstructor
@AllArgsConstructor
public class OrderQuantityBought {

=======
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderQuantityBought {
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
    @EmbeddedId
    OrderQuantityKey id;

    @ManyToOne
<<<<<<< HEAD
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id")
    private Transaction transactionId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product productId;

    private int quantity;

=======
    @MapsId("orderId")
    @JoinColumn(name="order_id")
    private Transaction order_id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="Product_id")
    private Product product_id;

    private int quantity;




>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
}
