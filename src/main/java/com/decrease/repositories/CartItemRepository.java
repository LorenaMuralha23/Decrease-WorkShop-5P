package com.decrease.repositories;

import com.decrease.entities.CartItem;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a itens de carrinho.
 */
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    
    /**
     * Remove todos os itens de carrinho.
     */
    void deleteAll();
    
    /**
     * Remove todos os itens de carrinho associados a um produto específico.
     * @param productId O ID do produto a ser removido dos itens de carrinho.
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM CartItem c WHERE c.id.product.id = ?1")
    void deleteByProductId(Integer productId);
    
    /**
     * Busca um item de carrinho pelo ID do produto.
     * @param productId O ID do produto associado ao item de carrinho.
     * @return Um objeto Optional contendo o item de carrinho, se encontrado, ou vazio caso contrário.
     */
    @Query("SELECT ci FROM CartItem ci WHERE ci.id.product.id = :productId")
    Optional<CartItem> findByProductId(@Param("productId") Integer productId);
    
}