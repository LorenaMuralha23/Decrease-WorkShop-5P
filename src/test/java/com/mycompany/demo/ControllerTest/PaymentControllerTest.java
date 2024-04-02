/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demo.ControllerTest;

import com.decrease.controller.PaymentController;
import com.decrease.entities.Order;
import com.decrease.entities.Payment;
import com.decrease.services.PaymentService;
import java.time.Instant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author USER
 */
public class PaymentControllerTest {
    
    @InjectMocks
    private PaymentController controller;
    
    @Mock
    private PaymentService service;
    
    public PaymentControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testGeneratePaymentMethodShouldReturnRightPayment(){
        Instant instant = Instant.parse("2024-03-14T10:15:30.00Z");
        Order order = new Order();
        int type = 1;
        Payment paymExpected = new Payment();
        Payment paymentMock = new Payment();
        
        when(service.generatePayment(any(Instant.class), any(Order.class), any(Integer.class))).thenReturn(paymentMock);
        
        Payment paymentReturned = controller.generatePayment(instant, order, type);
        
        assertEquals(paymExpected, paymentReturned);
    }
    
}
