package com.revature.models;

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
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "address_id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column
    private String street;

    @Column
    private String city;

    @Column
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

}
