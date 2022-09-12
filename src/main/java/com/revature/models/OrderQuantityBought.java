package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Order_Quantities_Bought")
@NoArgsConstructor
@AllArgsConstructor
public class OrderQuantityBought {

    @JsonIgnore
    @EmbeddedId
    OrderQuantityKey id = new OrderQuantityKey();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Transaction.class)
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id")
    private Transaction transactionId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, targetEntity = Product.class)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product productId;

    private int quantity;

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", quantity='" + getQuantity() + "'" +
                "}";
    }

}