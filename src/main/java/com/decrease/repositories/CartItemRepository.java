package com.decrease.repositories;

import com.decrease.entities.CartItem;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    
    void deleteAll();
    
    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.id.product.id = ?1")
    void deleteByProductId(Integer productId);
    
    @Query("SELECT ci FROM CartItem ci WHERE ci.id.product.id = :productId")
    Optional<CartItem> findByProductId(@Param("productId") Integer productId);
    
}