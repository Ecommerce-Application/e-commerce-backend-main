package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderQuantityKey implements Serializable {
    @Column(name = "tran_id")
    private int tran_Id;

    @Column(name = "product_Id")
    private int productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderQuantityKey that = (OrderQuantityKey) o;
        return tran_Id == that.tran_Id && productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tran_Id, productId);
    }
}
