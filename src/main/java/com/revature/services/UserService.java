package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

<<<<<<< HEAD
//    public Optional<User> findByCredentials(String email, String password) {
//        return userRepository.findByEmailAndPassword(email, password);
//    }
=======
    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByUserEmailAndUserPassword(email, password);
    }
>>>>>>> a4d472441f60ffe298410be441c00293285ad453

    public User save(User user) {
        return userRepository.save(user);
    }
}
