package com.revature.models;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class OrderQuantityKey implements Serializable {

    @Column(name = "tran_id")
    private int transactionId;

    @Column(name = "product_id")
=======
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
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
<<<<<<< HEAD
=======

>>>>>>> a4d472441f60ffe298410be441c00293285ad453
@Data
public class OrderQuantityKey implements Serializable {
    @Column(name = "tran_id")
    private int tran_Id;

    @Column(name = "product_Id")
<<<<<<< HEAD
=======
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
    private int productId;

    @Override
    public boolean equals(Object o) {
<<<<<<< HEAD
=======
<<<<<<< HEAD
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OrderQuantityKey that = (OrderQuantityKey) o;
        return transactionId == that.transactionId && productId == that.productId;
=======
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderQuantityKey that = (OrderQuantityKey) o;
        return tran_Id == that.tran_Id && productId == that.productId;
<<<<<<< HEAD
=======
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(tran_Id, productId);
    }
=======
<<<<<<< HEAD
        return Objects.hash(transactionId, productId);
    }

=======
        return Objects.hash(tran_Id, productId);
    }
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
}
