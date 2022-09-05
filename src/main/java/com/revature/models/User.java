package com.revature.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
public class User {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
