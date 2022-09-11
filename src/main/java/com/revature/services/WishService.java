package com.revature.services;

import com.revature.exceptions.WishNotFoundException;
import com.revature.models.Product;
import com.revature.models.User;
import com.revature.models.Wish;
import com.revature.models.WishKey;
import com.revature.repositories.WishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WishService {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private WishRepository wishRepo;

    @Autowired
    public WishService(WishRepository wishRepo) {
        this.wishRepo = wishRepo;
    }

    @Transactional(readOnly = true)
    public List<Wish> getWishesByUserId(int userId) {
        log.info("Found Wishlist for User: " + userId );
        return wishRepo.findByUserId(userId).orElse(null);
    }

    @Transactional(readOnly = true)
    public Wish getWishByUserIdAndProductId(int userId, int productId) {
        log.info("Found wish with user id {} and product id {}.", userId, productId);
        return wishRepo.findByUserIdAndProductId(userId, productId)
                .orElseThrow(() -> new WishNotFoundException("Wish with user id " + userId +
                        " and product id " + productId + " not found."));
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Wish addWish(User user, Product product) {
        WishKey wishKey = new WishKey(user.getUserId(), product.getProdId());
        Wish newWish = new Wish(wishKey, user, product);
        log.info("Added a new Wish for User: " + user.getUserId());
        return wishRepo.save(newWish);
    }

    @Transactional
    public void deleteWish(User user, Product product) {
        wishRepo.deleteWishByWishKey(user.getUserId(), product.getProdId());
        log.info("Deleted Wish for User: " + user.getUserId());
    }

    @Transactional
    public void deleteAllWishes(User user) {
        wishRepo.deleteAllWishes(user.getUserId());
        log.info("Deleted all Wishes for User: " + user.getUserId());
    }

}
