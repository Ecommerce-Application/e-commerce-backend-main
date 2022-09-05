package com.revature.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
<<<<<<< HEAD
import java.util.List;
=======
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
>>>>>>> a4d472441f60ffe298410be441c00293285ad453

@Entity
<<<<<<< HEAD
@Table(name="users")
@Getter
@Setter
=======
@Table(name = "users")
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
public class User {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private int user_id;

    @Column(nullable = false)
    @Length(min = 1)
    private String first_name;

    @Column(nullable = false)
    @Length(min = 1)
    private String last_name;

    @Column(nullable = false, unique = true)
    @Email
    private String user_email;

    @Column(nullable = false)
    @Length(min = 1)
    private String user_password;

    @Column
    private String token_id;

//    One-to-Many relationship
    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Address> address_id;

    @OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Payment> payment_id;


    private int user_payment;
=======
    private int userId;

    @Column(nullable = false, unique = true)
    @Email
    private String userEmail;

    @Column(nullable = false)
    @NotBlank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")
    private String userPassword;

    @Column(nullable = false)
    @Length(min = 2)
    private String firstName;

    @Column(nullable = false)
    @Length(min = 2)
    private String lastName;

    @Column
    private String tokenId;

    // private int userPayment;

    // One-To-Many Relationships
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Address> addressId;

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Payment> paymentId;

>>>>>>> a4d472441f60ffe298410be441c00293285ad453
}
