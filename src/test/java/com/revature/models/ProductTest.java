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
        this.dummyProd = new Product(1, 1, 1, "someDesc", "someImage", "someName", null);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.dummyProd = null;
    }

    @Test
    void getById() {

        // given(this.dummyProd.getProdId());
        int expected = 1;
        int actual = this.dummyProd.getProdId();

        assertEquals(expected, actual);
    }

    // @Test
    // void getById_Failure() {
    //
    // //given(this.dummyProd.getProdId());
    // int expected = 2;
    // int actual = this.dummyProd.getProdId();
    //
    // try {
    //
    // } catch (Exception e) {
    // // prove that the Exception thrown was indeed a ProductNotFoundException
    // assertEquals(ProductNotFoundException.class, e.getClass());
    // }
    //
    //
    //
    // }

}