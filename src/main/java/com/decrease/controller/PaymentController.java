package com.decrease.controller;

import com.decrease.entities.Order;
import com.decrease.entities.Payment;
import com.decrease.services.PaymentService;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    public PaymentController() {
    }
    
    public Payment generatePayment(Instant moment, Order order, Integer type){
        return service.generatePayment(moment, order, type);
    }
    
}
