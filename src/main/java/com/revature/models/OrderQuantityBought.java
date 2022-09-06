package com.revature.models;

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

    @EmbeddedId
    OrderQuantityKey id;

    @ManyToOne
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id")
    private Transaction transactionId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product productId;

    private int quantity;

}
