package com.decrease.services;

import com.decrease.controller.SessionController;
import com.decrease.entities.Order;
import com.decrease.entities.OrderItem;
import com.decrease.entities.User;
import com.decrease.repositories.OrderItemRepository;
import com.decrease.repositories.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private OrderItemRepository orderItemRepository;
    
    public InvoiceService() {
    }
    
    public void generateInvoice(){
        //Pegar o id do último pedido adicionado
        Long lastOrderId = orderRepository.findMaxOrderId();
        //Achar o pedido usando esse id
        Optional<Order> order = orderRepository.findById(lastOrderId);
        //Buscar a lista de itens desse pedido usando esse id
        if (!order.isEmpty()){
            List<OrderItem> orderItems = orderItemRepository.findByOrderId(lastOrderId);
            User userLogged = SessionController.getInstance().getUserLogged();
            
            
        }
        //gerar a nota fiscal
    }
    
    
}
