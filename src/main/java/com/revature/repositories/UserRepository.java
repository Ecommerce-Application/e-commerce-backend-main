package com.revature.repositories;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

<<<<<<< HEAD
//    Optional<User> findByEmailAndPassword(String email, String password);
=======
    Optional<User> findByUserEmailAndUserPassword(String email, String password);
>>>>>>> a4d472441f60ffe298410be441c00293285ad453
}
