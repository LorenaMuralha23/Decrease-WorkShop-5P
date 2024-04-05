package com.decrease.repositories;

import com.decrease.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a pedidos.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}