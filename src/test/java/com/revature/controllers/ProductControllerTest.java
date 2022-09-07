package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.revature.dtos.ProductDTO;
import com.revature.models.Product;
import com.revature.repositories.ProductRepository;
import com.revature.services.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import com.google.gson.Gson;


import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductRepository prodRep;
    @InjectMocks
    ProductService prodSer = new ProductService(prodRep);
    ProductController prodCon = new ProductController(prodSer);
    private static final ModelMapper modelMapper = new ModelMapper();

    Product testProduct1;
    Product testProduct2;
    ProductDTO testProdTO;
    List<Product> testProdList;
    Gson gson = new Gson();


    //Test Setup
    @BeforeEach
    void setUp() {



        this.testProduct1 = new Product
                (
                1,
                10,
                20.5,
                "someDesc",
                "someImage",
                "someName"
                );
        this.testProduct1 = new Product
                (
                 1,
                 10,
                 20.5,
                 "someDesc",
                 "someImage",
                 "someName"
                );

        this.testProdTO = new ProductDTO(1, 1);

        this.testProdList.add(testProduct1);
    }

    @AfterEach
    void tearDown() {

        this.testProduct1 = null;
        this.testProduct2 = null;
        this.testProdTO = null;
    }

    //Test Collection
    @Test
    void getInventory() {
    }

    @Test
    void getProdById_SUCCESS() {
        given(this.prodSer.findById(1)).willReturn(Optional.of(this.testProduct1));

        Optional<Product> expected = Optional.of(this.testProduct1);
        //Optional<Product> actual = Optional.of(this.prodCon.getProductById(testProduct1.getProdId()));

        //assertEquals(expected, actual);
        //verify(this.prodCon, times(1)).getProductById(testProduct1.getProdId());
    }
    @Test
    void getProdById_FAILURE_ThrowsException() {

        given(this.prodSer.findById(-1)).willReturn(Optional.empty());

        assertNull(this.prodSer.findById(testProduct1.getProdId()));

        verify(this.prodSer, times(1)).findById(testProduct1.getProdId());
    }

    @Test
    void upsertProduct() {
    }

    @Test
    void purchaseProduct() {
    }

    @Test
    void deleteProduct() {
    }

    @Test
    void polyProductSearch() {
    }
}