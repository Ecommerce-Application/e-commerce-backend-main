package com.revature.services;

import com.revature.models.OrderQuantityBought;
import com.revature.models.OrderQuantityKey;
import com.revature.models.Product;
import com.revature.models.Transaction;
import com.revature.repositories.TransactionRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    TransactionRepo mockRepo;

    @InjectMocks
    TransactionService tranServiceMock;

    Transaction fakeTransaction;
    OrderQuantityBought fakeQty;

    @BeforeEach
    void setup(){
        List<OrderQuantityBought>list=new ArrayList<>();
        OrderQuantityKey key =new OrderQuantityKey(1,1);
        Product p=new Product();
        p.setProdId(1);

        this.fakeTransaction=new Transaction(1,1,20.2,20000,null);


    }


    @Test
    void add() {
    }

    @Test
    void findByUserId() {
    }
}