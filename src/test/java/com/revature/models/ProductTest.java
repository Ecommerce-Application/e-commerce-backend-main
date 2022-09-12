package com.revature.models;

import com.revature.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ProductTest {

    Product dummyProd;

    @BeforeEach
    void setUp() throws Exception {
        this.dummyProd = new Product(1, 1, "someDesc", "someImage", "someName");
    }

    @AfterEach
    void tearDown() throws Exception {
        this.dummyProd = null;
    }

    @Test
    void getProdId() {

        int expected = 0;
        int actual = this.dummyProd.getProdId();

        assertEquals(expected, actual);
    }

    @Test
    void getProdQuantity() {
    }

    @Test
    void getProdPrice() {
    }

    @Test
    void getProdDesc() {
    }

    @Test
    void getProdImage() {
    }

    @Test
    void getProdName() {
    }

    @Test
    void getQuantityBoughts() {
    }

    @Test
    void setProdId() {
    }

    @Test
    void setProdQuantity() {
    }

    @Test
    void setProdPrice() {
    }

    @Test
    void setProdDesc() {
    }

    @Test
    void setProdImage() {
    }

    @Test
    void setProdName() {
    }

    @Test
    void setQuantityBoughts() {
    }
}