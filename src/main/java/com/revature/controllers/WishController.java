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
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Product>> getWishesByUserId(@PathVariable("user_id") int userId) {
        System.out.println(userId + "First Print");
        List<Wish> wishes = new ArrayList<Wish>(wishService.getWishesByUserId(userId));
        List<Product> prodList = new ArrayList<Product>();
        System.out.println(wishes.toString());
        System.out.println(wishes.size());
        for(int i = 0; i <= wishes.size() - 1; i++) {
            Product item = wishes.get(i).getProduct();
            System.out.println(item + "Second Print");
//            Product p = productService.findById(item);
//                    .orElseThrow( () ->
//                    new ProductNotFoundException("No product with id " + item + " found."));
            System.out.println(item + "Third Print");
            prodList.add(item);
        }
        System.out.println(prodList);
        return ResponseEntity.ok(prodList);
    }

    @PostMapping("/post/{user_id}/{prod_id}")
    public ResponseEntity<Wish> addWish(@PathVariable("user_id") int userId,
                                        @PathVariable("prod_id") int prodId ) {
//        try {
//            wishService.getWishByUserIdAndProductId(userId, prodId);
//        } catch(WishNotFoundException e) {
//            return new ResponseEntity<Wish>(HttpStatus.NOT_FOUND);
//        }
        System.out.println(userId + "User ID");
        System.out.println(prodId + "Prod ID");
        User user = userService.findByUserId(userId);
        System.out.println(user + "Full user");
        Product product = productService.findById(prodId).orElseThrow( () ->
                new ProductNotFoundException("No product with id " + prodId + " found."));
        System.out.println(product + "Full product");
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
