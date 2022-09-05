package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderQuantityBought {
    @EmbeddedId
    OrderQuantityKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name="order_id")
    private Transaction order_id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name="Product_id")
    private Product product_id;

    private int quantity;
}
