package com.decrease.repositories;

import com.decrease.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a carrinhos de compras.
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {
    
}