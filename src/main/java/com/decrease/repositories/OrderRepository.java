package com.decrease.repositories;

import com.decrease.entities.Order;
import com.decrease.entities.OrderItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Interface que define um repositório para operações de acesso a dados
 * relacionados a pedidos.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT MAX(o.id) FROM Order o")
    Long findMaxOrderId();

}
