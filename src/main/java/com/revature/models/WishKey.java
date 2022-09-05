package com.revature.models;

<<<<<<< HEAD
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
public class WishKey implements Serializable {
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "product_id")
    private int product_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WishKey that = (WishKey) o;
        return user_id == that.user_id && product_id == that.product_id;
=======
import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WishKey implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "product_id")
    private int productId;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        WishKey that = (WishKey) o;
        return userId == that.userId && productId == that.productId;
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(user_id, product_id);
=======
        return Objects.hash(userId, productId);
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
    }
}
