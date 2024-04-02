package com.decrease.ServicesTest;

import com.decrease.entities.Order;
import com.decrease.entities.Payment;
import com.decrease.repositories.PaymentRepository;
import com.decrease.services.PaymentService;
import java.time.Instant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class PaymentServiceTest {
   
    @InjectMocks
    private PaymentService service;
    
    @Mock
    private PaymentRepository repository;
    
    public PaymentServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
        openMocks(this);
    }
    
    @Test
    public void testGeneratePayment() {
        Instant instant = Instant.parse("2024-03-14T12:30:45Z");
        Order order = new Order();
        int type = 1;
        
        Payment paymentExcpected = new Payment(null, instant, order, type);
        
        Payment paymentReturned = service.generatePayment(instant, order, type);
        
        verify(repository, times(1)).save(paymentExcpected);
        assertEquals(paymentExcpected.getId(), paymentReturned.getId());
        assertEquals(paymentExcpected.getMoment(), paymentReturned.getMoment());
        assertEquals(paymentExcpected.getOrder().getId(), paymentReturned.getOrder().getId());
        assertEquals(paymentExcpected.getType(), paymentReturned.getType());
    }
}