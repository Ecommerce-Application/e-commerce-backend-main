package com.revature.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.revature.dtos.ProductDTO;
import com.revature.exceptions.ProductNotFoundException;
import com.revature.models.Product;
import com.revature.repositories.ProductRepository;
import com.revature.services.ProductService;
import com.revature.controllers.ProductController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    ProductRepository testProdRep;
    @InjectMocks
    ProductService testProdSer;
    @InjectMocks
    ProductController testProdCon;

    Product testProduct1;
    Product testProduct2;
    ProductDTO testProdTO;
    List<Product> testProdList;
    List<ProductDTO> testTOList;




    //Test Setup
    @BeforeEach
    void setUp() {
        this.testProdSer = new ProductService(testProdRep);
        this.testProdCon = new ProductController(testProdSer);

        this.testProduct1 = new Product(1, 10, 20.5, "someDesc", "someImage", "someName");
        this.testProduct1 = new Product(1, 10, 20.5, "someDesc", "someImage", "someName");

        this.testProdList = new ArrayList<>();
        this.testProdList.add(testProduct1);
        this.testProdTO = new ProductDTO(1, 1);
        this.testTOList = new ArrayList<>();
        this.testTOList.add(this.testProdTO);
    }

    @AfterEach
    void tearDown() {
        this.testProduct1 = null;
        this.testProduct2 = null;
        this.testProdTO = null;
        this.testProdList = null;
        this.testTOList = null;
        this.testProdCon = null;
        this.testProdSer = null;
    }

    //Test Collection
    @Test
    void getInventory() {
    }

    @Test
    void getProdById_SUCCESS() {

        given(this.testProdRep.findById(testProduct1.getProdId())).willReturn(Optional.of(this.testProduct1));
        given(this.testProdSer.findById(testProduct1.getProdId())).willReturn(Optional.of(this.testProduct1));


        Product expected = this.testProduct1;
        Product actual = (this.testProdCon.getProductById(testProduct1.getProdId())).getBody();

        assertEquals(expected, actual);
        //verify(this.testProdCon, times(1)).getProductById(1);
    }
    @Test
    void getProdById_FAILURE_ThrowsException() {

        int invalidID = -1;

        given(this.testProdSer.findById(invalidID)).willReturn(Optional.empty());

        try {
            this.testProdCon.getProductById(invalidID);
        } catch (Exception e) {
            // prove that the Exception thrown was indeed a ProductNotFoundException
            assertEquals(ProductNotFoundException.class, e.getClass());
        }
        //verify(this.testProdSer, times(1)).findById(testProduct1.getProdId());
    }

    @Test
    void upsertProduct() {
        //PUT map
        given(this.testProdSer.save(this.testProduct1)).willReturn((this.testProduct1));
        Product expected = this.testProduct1;
        Product actual = (this.testProdCon.upsertProduct(this.testProduct1)).getBody();

        assertEquals(expected, actual);
    }

    @Test
    void purchaseProduct_SUCCESS() {
        //PATCH map
        //given(this.testProdSer.findById(this.testProduct1.getProdId())).willReturn(Optional.of(this.testProduct1));

        //this.testProdCon.purchaseProduct(this.testProdTO);

    }
    @Test
    void purchaseProduct_FAILURE_InvException() {
        //PATCH map

    }

    @Test
    void deleteProduct() {
    }

    @Test
    void polyProductSearch() {
    }
}