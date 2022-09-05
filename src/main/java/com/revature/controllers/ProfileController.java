package com.revature.controllers;

import com.revature.dtos.PasswordRequest;
import com.revature.dtos.RegisterRequest;
import com.revature.exceptions.UnauthorizedSessionException;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.util.JwtTokenManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/profile")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:3000"}, allowCredentials = "true",
        allowedHeaders = "*")
public class ProfileController {
    private UserService userService;
    private JwtTokenManager tokenManager;
    private ModelMapper modelMapper = new ModelMapper();

//    Constructors
    @Autowired
    public ProfileController(UserService userService, JwtTokenManager tokenManager) {
        this.userService = userService;
        this.tokenManager = tokenManager;
    }

//    Methods
    @GetMapping
    public ResponseEntity<User> getUserBasicInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            userService.validateSession(request.getHeader("rolodex-token"));
        } catch (UnauthorizedSessionException e) {
            e.printStackTrace();
            response.addHeader("error-message", "Provided credentials are incorrect.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new User());
        }

        String userToken = request.getHeader("rolodex-token");
        String userEmail = tokenManager.parseUserEmailFromToken(userToken);
        int userId = tokenManager.parseUserIdFromToken(userToken);
        User user = userService.getByEmailAndId(userEmail, userId);
        if (user != null) {
            response.addHeader("rolodex-token", userToken);
            response.addHeader("Access-Control-Expose-Header", "rolodex-token");
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            response.addHeader("error-message", "User not found.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User());
        }
    }

    @PatchMapping
    public ResponseEntity<User> setNewPassword(@Valid @RequestBody PasswordRequest passwordDTO,
                                               HttpServletRequest request, HttpServletResponse response) {
        try {
            userService.validateSession(request.getHeader("rolodex-token"));
        } catch (UnauthorizedSessionException e) {
            e.printStackTrace();
            response.addHeader("error-message", "Provided credentials are incorrect.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new User());
        }

        User newPassword = modelMapper.map(passwordDTO, User.class);
        String userToken = request.getHeader("rolodex-token");
        String userEmail = tokenManager.parseUserEmailFromToken(userToken);
        int userId = tokenManager.parseUserIdFromToken(userToken);
        User userUpdatedPassword = userService.setNewPassword(userEmail, userId, newPassword.getUserPassword());
        if (userUpdatedPassword != null) {
            response.addHeader("rolodex-token", userToken);
            response.addHeader("Access-Control-Expose-Header", "rolodex-token");
            userUpdatedPassword.setUserPassword(newPassword.getUserPassword());
            return ResponseEntity.status(HttpStatus.OK).body(userUpdatedPassword);
        } else {
            response.addHeader("error-message", "Password is not updated.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new User());
        }
    }


}
