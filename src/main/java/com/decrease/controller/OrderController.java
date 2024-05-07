package com.decrease.controller;

import com.decrease.entities.Order;
import com.decrease.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderController {
    
    @Autowired 
    private OrderService service;

    public OrderController() {
    }
    
    public Order saveOrder(Order newOrder){
        return service.saveOrder(newOrder);
    }
    
}
