package com.revature.models;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

=======
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
=======
import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
    private int userId;
    private double total;
    private long datePlaced;

<<<<<<< HEAD
    @OneToMany(mappedBy = "transactionId")
    private List<OrderQuantityBought> orderQuantityBoughts;

=======
    @OneToMany(mappedBy = "order_id")
    private List<OrderQuantityBought> orderQuantityBoughts;
>>>>>>> c4351952ca92066fdf6b8436ecb0f7a07e59985b
}
