package com.revature.services;

import com.revature.exceptions.UserNotFoundException;
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

    public Optional<User> findByCredentials(String email, String password) {
        return userRepository.findByUserEmailAndUserPassword(email, password);
    }

    public User findByUserId(int userId) {
        return userRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException("No user " +
                "found with id: " + userId ));
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
