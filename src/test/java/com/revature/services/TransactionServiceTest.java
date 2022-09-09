package com.revature.services;

import com.revature.dtos.TransactionDto;
import com.revature.dtos.TransactionQtyDTO;
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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class TransactionServiceTest {

    @Mock
    TransactionRepo mockRepo;

    @InjectMocks
    TransactionService tranServiceMock;

    Transaction fakeTransaction;
    TransactionDto input;
    OrderQuantityBought fakeQty;}

    //@BeforeEach
//    void setup(){
//        List<OrderQuantityBought>list=new ArrayList<>();
//        OrderQuantityKey key =new OrderQuantityKey(1,1);
//        OrderQuantityBought ob =new OrderQuantityBought();
//        TransactionQtyDTO tr=new TransactionQtyDTO(1,3);
//        List<TransactionQtyDTO> list1 =new ArrayList<>();
//        Product p=new Product();
//        p.setProdId(1);
//        p.setProdDesc("decc");
//        p.setProdImage("image");
//        p.setProdName("name");
//        p.setProdPrice(19.95);
//        p.setProdQuantity(100);
//
//
//        this.fakeTransaction=new Transaction(1,1,20.2,20000,list);
//        this.input=new TransactionDto(1,20.2,20000,list1);
//
//        ob.setTransactionId(fakeTransaction);
//        ob.setQuantity(3);
//        ob.setProductId(p);
//        ob.setId(key);
//       list.add(ob);
//       //fakeTransaction.setOrderQuantityBoughts(list);
//       input.getOrderQuantityBoughts().add(tr);
//
//
//
//    }}


//    @Test
//    void add() {
//
//        given(this.mockRepo.save(this.fakeTransaction)).willReturn(this.fakeTransaction);
//        Transaction expected=this.fakeTransaction;
//
//        Transaction actual=tranServiceMock.add(this.input);
//
//        assertEquals(expected.getTransactionId(),actual.getTransactionId());
//
//        verify(this.mockRepo,times(1)).save(this.fakeTransaction);
//
//    }
//
//    @Test
//    void findByUserId() {
//
//        Optional<List<Transaction>> actual=tranServiceMock.findByUserId(1);
//    }
//}