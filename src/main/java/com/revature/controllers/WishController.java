package com.revature.controllers;

import com.revature.exceptions.ProductNotFoundException;
import com.revature.exceptions.WishNotFoundException;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.models.Wish;
import com.revature.services.ProductService;
import com.revature.services.UserService;
import com.revature.services.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wish")
public class WishController {

    private WishService wishService;
    private UserService userService;
    private ProductService productService;

    @Autowired
    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @GetMapping("/get/{user_id}")
    public ResponseEntity<List<Wish>> getWishesByUserId(@PathVariable("user_id") int userId) {
        List<Wish> wishes = new ArrayList<Wish>(wishService.getWishesByUserId(userId));
        return ResponseEntity.ok(wishes);
    }

    @PostMapping("/post/{user_id}/{prod_id}")
    public ResponseEntity<Wish> addWish(@PathVariable("user_id") int userId,
                                        @PathVariable("prod_id") int prodId ) {
//        try {
//            wishService.getWishByUserIdAndProductId(userId, prodId);
//        } catch(WishNotFoundException e) {
//            return new ResponseEntity<Wish>(HttpStatus.NOT_FOUND);
//        }
        User user = userService.findByUserId(userId);
        Product product = productService.findById(prodId).orElseThrow( () ->
                new ProductNotFoundException("No product with id " + prodId + " found."));
        return ResponseEntity.ok(wishService.addWish(user, product));
    }

    @DeleteMapping("/delete/{user_id}/{prod_id}")
    public void deleteWish(@PathVariable("user_id") int userId, @PathVariable("prod_id") int prodId ) {
        User user = userService.findByUserId(userId);
        Product product = productService.findById(prodId).orElseThrow( () ->
                new ProductNotFoundException("No product with id " + prodId + " found."));
        wishService.deleteWish(user, product);
    }

    @DeleteMapping("/delete_all/{user_id}")
    public void deleteAllWishes(@PathVariable("user_id") int userId) {
        User user = userService.findByUserId(userId);
        wishService.deleteAllWishes(user);
    }

}
