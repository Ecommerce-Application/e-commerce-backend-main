package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
