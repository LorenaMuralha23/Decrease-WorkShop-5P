package com.decrease.repositories;

import com.decrease.entities.OrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a itens de pedido.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("SELECT oi FROM OrderItem oi WHERE oi.id.order.id = :orderId")
    List<OrderItem> findByOrderId(@Param("orderId") Long orderId);
    
}