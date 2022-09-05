package com.revature.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="payments")
@Getter
@Setter
=======
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "payments")
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "payment_id")
public class Payment {

    @Id
<<<<<<< HEAD
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payment_id;

    @Column
    private String cc_number;

    @Column
    private String exp_period;

    @Column
    private String zip_code;

    @Column
    private String svc_code;

//    Many-to-One relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user_id;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Column
    private String ccNumber;

    @Column
    private String expPeriod;

    @Column
    private String zipCode;

    @Column
    private String svcCode;

    // Many-To-One Relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User userId;

>>>>>>> a4d472441f60ffe298410be441c00293285ad453
}
