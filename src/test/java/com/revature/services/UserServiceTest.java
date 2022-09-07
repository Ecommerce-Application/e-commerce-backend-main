package com.revature.services;

import com.revature.models.Address;
import com.revature.models.Payment;
import com.revature.models.User;
import com.revature.repositories.AddressRepository;
import com.revature.repositories.PaymentRepository;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepository mockUserRepository;
    @Mock
    AddressRepository mockAddressRepository;
    @Mock
    PaymentRepository mockPaymentRepository;

    @InjectMocks
    UserService userService;

    User dummyUser;
    Address dummyAddress;
    Payment dummyPayment;

    @BeforeEach
    void setUp() throws Exception {
        this.dummyUser = new User(1, "test@gmail.com", "12345", "Kai",
                "Freedom", "9999999999", null, null, null);
        this.dummyAddress = new Address(1, "5th Avenue", "Manhattan", "NY",
                "United States", "12345", null);
        this.dummyPayment = new Payment(1, "123456789", "01142022", "12345",
                "777", null);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.dummyUser = null;
        this.dummyAddress = null;
        this.dummyPayment = null;
    }

    @Test
    void testFindByCredentials() {
        String email = this.dummyUser.getUserEmail();
        String password = this.dummyUser.getUserPassword();
        given(this.mockUserRepository.findByUserEmailAndUserPassword(email, password))
                .willReturn(Optional.of(this.dummyUser));

        User expected = this.dummyUser;
        User actual = this.userService.findByCredentials(email, password);

        assertEquals(expected, actual);
        verify(this.mockUserRepository, times(1)).findByUserEmailAndUserPassword(email, password);
    }
}
