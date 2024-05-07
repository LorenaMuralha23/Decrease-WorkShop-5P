package com.decrease.services;

import com.decrease.entities.Order;
import com.decrease.entities.OrderItem;
import com.decrease.repositories.OrderItemRepository;
import com.decrease.repositories.OrderRepository;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository itemRepository;

    public OrderService() {
    }

    public Order saveOrder(Order newOrder) {
        Order savedOrder = repository.save(newOrder);

        if (savedOrder != null) {
            for (OrderItem item : newOrder.getOrderItems()) {
                item.setOrder(savedOrder);
                itemRepository.save(item);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o pedido.");
        }

        return savedOrder;
    }

}
