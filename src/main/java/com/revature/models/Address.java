package com.revature.models;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name="addresses")
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
@Table(name = "addresses")
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "address_id")
public class Address {

    @Id
<<<<<<< HEAD
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int address_id;
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
>>>>>>> a4d472441f60ffe298410be441c00293285ad453

    @Column
    private String street;

    @Column
    private String city;

    @Column
<<<<<<< HEAD
    private String country;

    @Column
    private String zip_code;

//    Many-to-One relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user_id;
=======
    private String state;

    @Column
    private String country;

    @Column
    private String zipCode;

    // Many-To-One Relationship
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    @JsonBackReference
    private User userId;

>>>>>>> a4d472441f60ffe298410be441c00293285ad453
}
