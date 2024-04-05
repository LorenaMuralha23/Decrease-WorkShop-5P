package com.decrease.repositories;

import com.decrease.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a itens de pedido.
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}